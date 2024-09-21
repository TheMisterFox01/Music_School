package com.music_school.repository;

import com.music_school.model.Login;
import com.music_school.model.LoginRequest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenValidatorRepositoryImpl implements TokenValidatorRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SQL_FIND_TOKEN =
            "select * from token t where t.tokens = :token and t.date = :date";

    public TokenValidatorRepositoryImpl(
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean validateToken(String token, Date date) {
        var params = new MapSqlParameterSource();
        params.addValue("token", token);
        params.addValue("date", date);
        var result = jdbcTemplate.queryForObject(SQL_FIND_TOKEN, params,
                (rs, rowNum) ->
                new Login(rs.getString("tokens")));
        return result != null;
    }

}
