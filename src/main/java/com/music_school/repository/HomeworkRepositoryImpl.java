package com.music_school.repository;


import com.music_school.mapper.HomeworkMapper;
import com.music_school.model.Homework;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class HomeworkRepositoryImpl implements HomeworkRepository{




    private static final String SQL_GET_HOMEWORKS_BY_STUDENT_ID =
            "select student_id ,group_id, first_name, second_name from public.student where group_id = :group_id";

    private static final String SQL_GET_HOMEWORK_BY_ID =
            "select student_id, group_id, first_name, second_name from public,student where student_id = :student_id";

    private static final String SQL_UPDATE_HOMEWORK =
            "update public.student set first_name = :first_name, second_name = :second_name where student_id = :student_id";

    private static final String SQL_INSERT_HOMEWORK =
            "insert into public.group (teacher_id) values (:teacher_id)";

    private final HomeworkMapper homeworkMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public HomeworkRepositoryImpl(
            HomeworkMapper homeworkMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.homeworkMapper = homeworkMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Homework> getHomeworksByStudentId(int student_id){
        var params = new MapSqlParameterSource();
        params.addValue("student_id", student_id);
        return jdbcTemplate.query(
                SQL_GET_HOMEWORKS_BY_STUDENT_ID,
                params,
                homeworkMapper
        );
    }

    @Override
    public Optional<Homework> getHomeworkById(int homework_id){
        var params = new MapSqlParameterSource();
        params.addValue("homework_id", homework_id);
        return jdbcTemplate.query(
                        SQL_GET_HOMEWORK_BY_ID,
                        params,
                        homeworkMapper
                ).stream()
                .findFirst();
    }

    @Override
    public void insertHomework(int student_id, Timestamp date_until){
        var params = new MapSqlParameterSource();
        params.addValue("student_id", student_id);
        params.addValue("date_until", date_until);
        jdbcTemplate.update(SQL_INSERT_HOMEWORK, params);
    }

    @Override
    public void updateHomeworkById(int grade, int homework_id){
        var params = new MapSqlParameterSource();
        params.addValue("grade", grade);
        params.addValue("homework_id", homework_id);
        jdbcTemplate.update(SQL_UPDATE_HOMEWORK, params);
    }
}
