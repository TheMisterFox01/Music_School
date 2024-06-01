package com.music_school.model;

public record HomeworkRequest(
        int homework_id,
        int student_id,
        int grade
) {
}
