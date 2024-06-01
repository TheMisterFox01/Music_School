package com.music_school.mapper;


import com.music_school.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(
                rs.getInt("student_id"),
                rs.getString("first_name"),
                rs.getString("second_name"),
                rs.getInt("group_id")
        );
    }
}
