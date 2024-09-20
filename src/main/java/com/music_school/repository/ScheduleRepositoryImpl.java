package com.music_school.repository;

import com.music_school.mapper.ScheduleMapper;
import com.music_school.model.Schedule;
import com.music_school.model.ScheduleRequest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    private static final String SQL_GET_SCHEDULE =
            "select class_id ,group_id, date, lesson_number from public.schedule";

    private static final String SQL_INSERT_NEW_SCHEDULE =
            "insert into public.schedule (class_id, group_id, date, lesson_number) values (:class_id, :group_id, " +
                    ":date, :lesson_number)";


    private final ScheduleMapper scheduleMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    record CustomSql(String sql, Map<String, Object> args) {
    }

    public ScheduleRepositoryImpl(
            ScheduleMapper scheduleMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.scheduleMapper = scheduleMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Schedule> getSchedule(ScheduleRequest request) {
        ScheduleRepositoryImpl.CustomSql reportSql = buildReportSql(request);
        return jdbcTemplate.query(reportSql.sql,
                new MapSqlParameterSource(reportSql.args),
                (rs, rowNum) ->
                        new Schedule(rs.getInt("classId"),
                                rs.getInt("groupId"),
                                rs.getTimestamp("date"),
                                rs.getInt("lessonNumber"),
                                rs.getString("teacherLastName"),
                                rs.getString("teacherFirstName"))
        ).stream().toList();
    }

    @Override
    public void formNewSchedule(Schedule schedule) {
        var params = new MapSqlParameterSource();
        params.addValue("class_id", schedule.classId());
        params.addValue("group_id", schedule.groupId());
        params.addValue("date", schedule.date());
        params.addValue("lesson_number", schedule.lessonNumber());
        params.addValue("teacher_first_name", schedule.teacherFirstName());
        params.addValue("teacher_last_name", schedule.teacherLastName());
        jdbcTemplate.update(SQL_INSERT_NEW_SCHEDULE, params);
    }

    private ScheduleRepositoryImpl.CustomSql buildReportSql(ScheduleRequest request) {
        Map<String, Object> args = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        int dayOfWeek = request.date().toLocalDate().getDayOfWeek().getValue();

        sb.append("""
                select s.class_id as classId,
                s.group_id as groupId,
                s.date as date,
                s.lesson_number as lessonNumber,
                s.teacher_last_name as teacherLastName,
                s.teacher_first_name as teacherFirstName
                """);

        sb.append("from schedule s ");
        sb.append(" where ");

        if (request.classId() != null) {
            sb.append(" s.class_id = :classId and ");
            args.put("classId", request.classId());
        } else if (request.teacherLastName() != null) {
            sb.append(" s.teacher_last_name = :teacherLastName and s.teacher_first_name = :teacherFirstName and ");
            args.put("teacherLastName", request.teacherLastName());
            args.put("teacherFirstName", request.teacherFirstName());
        } else if (request.groupId() != null) {
            sb.append(" s.group_id = :groupId and ");
            args.put("groupId", request.groupId());
        }
        sb.append("  s.date between :firstDate and :secondDate ");
        sb.append(" order by s.date asc ");
        args.put("secondDate", request.date().toLocalDate().plusDays(7 - dayOfWeek));
        args.put("firstDate", request.date().toLocalDate().minusDays(dayOfWeek - 1));

        return new ScheduleRepositoryImpl.CustomSql(sb.toString(), args);
    }

}
