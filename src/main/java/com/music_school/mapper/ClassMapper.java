package com.music_school.mapper;

import com.music_school.model.Class;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ClassMapper implements RowMapper<Class> {

    @Override
    public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Class(
                rs.getInt("class_id"),
                rs.getInt("size")
        );
    }
}
