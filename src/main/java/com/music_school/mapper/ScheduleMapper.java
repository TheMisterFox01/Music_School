package com.music_school.mapper;

import com.music_school.model.Schedule;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ScheduleMapper implements RowMapper<Schedule> {

    @Override
    public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Schedule(
                rs.getInt("class_id"),
                rs.getInt("group_id"),
                rs.getTimestamp("date"),
                rs.getInt("lesson_number"),
                rs.getString("teacher_last_name"),
                rs.getString("teacher_first_name")
        );
    }
}
