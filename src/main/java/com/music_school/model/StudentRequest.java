package com.music_school.model;

public record StudentRequest(
        Integer studentId,
        String firstName,
        String secondName,
        Integer groupId
) {
}
