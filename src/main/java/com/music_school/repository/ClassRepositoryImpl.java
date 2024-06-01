package com.music_school.repository;

import com.music_school.mapper.ClassMapper;
import com.music_school.model.Class;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClassRepositoryImpl implements ClassRepository{

    private static final String SQL_GET_CLASS_BY_ID =
            "select class_id ,size from public.class where class_id = :class_id";

    private static final String SQL_INSERT_CLASS =
            "insert into public.class (class_id, size) values (:class_id, :size)";

    private static final String SQL_UPDATE_CLASS =
            "update public.class set size = :size where class_id = :class_id";

    private static final String SQL_DELETE_CLASS = "delete from public.class where class_id = :class_id";

    private final ClassMapper classMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ClassRepositoryImpl(
            ClassMapper classMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.classMapper = classMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Class> getClassById(int id){
        var params = new MapSqlParameterSource();
        params.addValue("class_id", id);
        return jdbcTemplate.query(
                        SQL_GET_CLASS_BY_ID,
                        params,
                        classMapper
                ).stream()
                .findFirst();
    }

    @Override
    public void insertClass(int id, int size){
        var params = new MapSqlParameterSource();
        params.addValue("class_id", id);
        params.addValue("size", size);
        jdbcTemplate.update(SQL_INSERT_CLASS, params);
    }

    @Override
    public void updateClassById(int id, int size){
        var params = new MapSqlParameterSource();
        params.addValue("class_id", id);
        params.addValue("size", size);
        jdbcTemplate.update(SQL_UPDATE_CLASS, params);
    }

    @Override
    public void deleteClassById(int id){
        var params = new MapSqlParameterSource();
        params.addValue("class_id", id);
        jdbcTemplate.update(SQL_DELETE_CLASS, params);
    }
}
