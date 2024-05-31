package com.music_school.repository;

import com.music_school.mapper.GroupMapper;
import com.music_school.model.Group;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class GroupRepositoryImpl implements GroupRepository{

    private static final String SQL_GET_GROUP_BY_ID =
            "select teacher_id ,group_id from group where group_id = :group_id";

    private static final String SQL_INSERT_GROUP =
            "insert into group (teacher_id) values (:teacher_id)";

    private static final String SQL_UPDATE_GROUP =
            "update group set teacher_id = :teacher_id where group_id = :group_id";

    private static final String SQL_DELETE_GROUP = "delete from group where group_id = :group_id";

    private final GroupMapper groupMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public GroupRepositoryImpl(
            GroupMapper groupMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.groupMapper = groupMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Group> getGroupById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("group_id", id);
        return jdbcTemplate.query(
                        SQL_GET_GROUP_BY_ID,
                        //params,
                        groupMapper
                ).stream()
                .findFirst();
    }

    @Override
    public void insertGroup(int teacher_id) {
        var params = new MapSqlParameterSource();
        params.addValue("teacher_id", teacher_id);
        jdbcTemplate.update(SQL_INSERT_GROUP, params);
    }

    @Override
    public void updateGroupById(int teacher_id, int id) {
        var params = new MapSqlParameterSource();
        params.addValue("teacher_id", teacher_id);
        params.addValue("group_id", id);
        jdbcTemplate.update(SQL_UPDATE_GROUP, params);
    }

    @Override
    public void deleteGroupById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("group_id", id);
        jdbcTemplate.update(SQL_DELETE_GROUP, params);
    }
}
