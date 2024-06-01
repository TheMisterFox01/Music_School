package com.music_school.mapper;

import com.music_school.model.Schedule;
import com.music_school.model.Teacher;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TeacherMapper implements RowMapper<Teacher> {


    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Teacher(
                rs.getInt("teacher_id"),
                rs.getString("first_name"),
                rs.getString("second_name")
        );
    }
}
