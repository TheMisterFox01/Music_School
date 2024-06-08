package com.music_school.repository;

import com.music_school.mapper.ScheduleMapper;
import com.music_school.mapper.StudentMapper;
import com.music_school.model.Schedule;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository{

    private static final String SQL_GET_SCHEDULE =
            "select class_id ,group_id, date, lesson_number from public.schedule";

    private static final String SQL_INSERT_NEW_SCHEDULE =
            "insert into public.schedule (class_id, group_id, date, lesson_number) values (:class_id, :group_id, " +
                    ":date, :lesson_number)";


    private final ScheduleMapper scheduleMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ScheduleRepositoryImpl(
            ScheduleMapper scheduleMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.scheduleMapper = scheduleMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Schedule> getSchedule() {
        return jdbcTemplate.query(
                SQL_GET_SCHEDULE,
                scheduleMapper
        );
    }

    @Override
    public void formNewSchedule(Schedule schedule) {
        var params = new MapSqlParameterSource();
        params.addValue("class_id", schedule.class_id());
        params.addValue("group_id", schedule.group_id());
        params.addValue("date", schedule.date());
        params.addValue("lesson_number", schedule.lesson_number());
        jdbcTemplate.update(SQL_INSERT_NEW_SCHEDULE, params);
    }
}
