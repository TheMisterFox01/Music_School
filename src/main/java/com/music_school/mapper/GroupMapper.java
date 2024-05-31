package com.music_school.mapper;

import com.music_school.model.Group;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class GroupMapper implements RowMapper<Group> {

    @Override
    public Group mapRow( ResultSet rs, int rowNum) throws SQLException {
        return new Group(
                rs.getInt("teacher_id"),
                rs.getInt("group_id")
        );
    }
}
