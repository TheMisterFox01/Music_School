package com.music_school.repository;

import com.music_school.model.Login;
import com.music_school.model.LoginRequest;

public interface LoginRepository {

    Login login(LoginRequest request);

}
