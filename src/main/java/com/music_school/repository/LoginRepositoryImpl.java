package com.music_school.repository;

import com.music_school.model.Login;
import com.music_school.model.LoginRequest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class LoginRepositoryImpl implements LoginRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SQL_INSERT_NEW_TOKEN =
            "insert into public.token (tokens, date) values (:token, :date)";

    public LoginRepositoryImpl(
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
    }

    record CustomSql(String sql, Map<String, Object> args) {
    }

    @Override
    public Login login(LoginRequest request) {
        LoginRepositoryImpl.CustomSql reportSql = buildReportSql(request);
        LoginRequest result = jdbcTemplate.queryForObject(reportSql.sql,
                new MapSqlParameterSource(reportSql.args),
                (rs, rowNum) ->
                        new LoginRequest(rs.getString("login"), ""));
        if (result != null) {
            String token = generateRandomString();
            var params = new MapSqlParameterSource();
            params.addValue("token", token);
            params.addValue("date", LocalDateTime.now());
            jdbcTemplate.update(SQL_INSERT_NEW_TOKEN, params);
            return new Login(token);
        } else {
            return new Login("");
        }
    }


    public String generateRandomString() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 40;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private LoginRepositoryImpl.CustomSql buildReportSql(LoginRequest request) {
        Map<String, Object> args = new HashMap<>();

        String sb = """
                select l.login as login
                from login l
                where l.login = :login and l.password = :password
                """;

        args.put("login", request.login());
        args.put("password", request.password());

        return new LoginRepositoryImpl.CustomSql(sb, args);
    }

}
