package com.music_school.repository;


import com.music_school.mapper.TeacherMapper;
import com.music_school.model.Teacher;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository{

    private static final String SQL_GET_TEACHER_BY_ID =
            "select teacher_id, first_name, second_name from public.teacher where teacher_id = :teacher_id";

    private static final String SQL_UPDATE_TEACHER =
            "update public.teacher set first_name = :first_name, second_name = :second_name where teacher_id = :teacher_id";

    private static final String SQL_INSERT_TEACHER =
            "insert into public.teacher (first_name, second_name) values (:first_name, :second_name)";

    private static final String SQL_DELETE_TEACHER =
            "delete from public.teacher where teacher_id = :teacher_id";

    private final TeacherMapper teacherMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public TeacherRepositoryImpl(
            TeacherMapper teacherMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.teacherMapper = teacherMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Teacher> getTeacherById(int id){
        var params = new MapSqlParameterSource();
        params.addValue("teacher_id", id);
        return jdbcTemplate.query(
                        SQL_GET_TEACHER_BY_ID,
                        params,
                        teacherMapper
                ).stream()
                .findFirst();
    }


    @Override
    public void insertTeacher(String first_name, String second_name){
        var params = new MapSqlParameterSource();
        params.addValue("first_name", first_name);
        params.addValue("second_name", second_name);
        jdbcTemplate.update(SQL_INSERT_TEACHER, params);
    }

    @Override
    public void updateTeacherById(int id, String first_name, String second_name){
        var params = new MapSqlParameterSource();
        params.addValue("teacher_id", id);
        params.addValue("first_name", first_name);
        params.addValue("second_name", second_name);
        jdbcTemplate.update(SQL_UPDATE_TEACHER, params);
    }

    @Override
    public void deleteTeacherById(int id){
        var params = new MapSqlParameterSource();
        params.addValue("teacher_id", id);
        jdbcTemplate.update(SQL_DELETE_TEACHER, params);
    }
}
