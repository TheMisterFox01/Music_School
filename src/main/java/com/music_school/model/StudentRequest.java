package com.music_school.model;

public record StudentRequest(
        int student_id,
        String first_name,
        String second_name,
        int group_id
) {
}
