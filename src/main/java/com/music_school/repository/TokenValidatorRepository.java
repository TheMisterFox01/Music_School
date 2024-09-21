package com.music_school.repository;

import java.util.Date;

public interface TokenValidatorRepository {

    boolean validateToken(String token, Date date);

}
