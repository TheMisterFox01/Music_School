package com.music_school.model;

public record TeacherRequest(
        Integer teacherId,
        String firstName,
        String secondName
) {
}
