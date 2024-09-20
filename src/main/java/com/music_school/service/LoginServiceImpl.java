package com.music_school.service;

import com.music_school.model.Login;
import com.music_school.model.LoginRequest;
import com.music_school.repository.LoginRepository;
import com.music_school.repository.ScheduleRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login login(LoginRequest request) {
        return loginRepository.login(request);
    }
}
