package com.music_school.model;

public record LoginRequest(
        String login,
        String password
) {
}
