package com.music_school.controller;

import com.music_school.model.Login;
import com.music_school.model.LoginRequest;
import com.music_school.service.LoginService;
import com.music_school.service.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping(value = "/login")
    public Login login(@RequestBody LoginRequest request) {
        return loginService.login(request);
    }

}
