package com.music_school.mapper;

import com.music_school.model.Homework;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HomeworkMapper implements RowMapper<Homework> {

    @Override
    public Homework mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Homework(
                rs.getInt("homework_id"),
                rs.getInt("student_id"),
                rs.getTimestamp("date_until"),
                rs.getInt("grade")
        );
    }
}
