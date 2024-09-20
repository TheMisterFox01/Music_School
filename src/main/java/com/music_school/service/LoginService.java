package com.music_school.service;

import com.music_school.model.Login;
import com.music_school.model.LoginRequest;

public interface LoginService {
    Login login(LoginRequest request);
}
