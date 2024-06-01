package com.music_school.repository;

import com.music_school.mapper.StudentMapper;
import com.music_school.model.Student;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepositoryImpl implements StudentRepository{


    private static final String SQL_GET_STUDENTS_BY_GROUP_ID =
            "select student_id ,group_id, first_name, second_name from public.student where group_id = :group_id";

    private static final String SQL_GET_STUDENT_BY_ID =
            "select student_id, group_id, first_name, second_name from public,student where student_id = :student_id";

    private static final String SQL_UPDATE_STUDENT =
            "update public.student set first_name = :first_name, second_name = :second_name where student_id = :student_id";

    private static final String SQL_INSERT_STUDENT =
            "insert into public.student (first_name, second_name) values (:first_name, :second_name)";

    private final StudentMapper studentMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StudentRepositoryImpl(
            StudentMapper studentMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.studentMapper = studentMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> getStudentsByGroupId(int group_id) {
        var params = new MapSqlParameterSource();
        params.addValue("group_id", group_id);
        return jdbcTemplate.query(
                        SQL_GET_STUDENTS_BY_GROUP_ID,
                        params,
                        studentMapper
                );
    }

    @Override
    public Optional<Student> getStudentById(int student_id){
        var params = new MapSqlParameterSource();
        params.addValue("student_id", student_id);
        return jdbcTemplate.query(
                        SQL_GET_STUDENT_BY_ID,
                        params,
                        studentMapper
                ).stream()
                .findFirst();
    }

    @Override
    public void updateStudentById(int student_id, String first_name, String second_name) {
        var params = new MapSqlParameterSource();
        params.addValue("student_id", student_id);
        params.addValue("first_name", first_name);
        params.addValue("second_name", second_name);
        jdbcTemplate.update(SQL_UPDATE_STUDENT, params);
    }

    @Override
    public void insertStudent(String first_name, String second_name) {
        var params = new MapSqlParameterSource();
        params.addValue("first_name", first_name);
        params.addValue("second_name", second_name);
        jdbcTemplate.update(SQL_INSERT_STUDENT, params);
    }
}
