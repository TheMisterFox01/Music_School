package com.music_school.model;

public record ScheduleRequest(
        int class_id,
        int group_id,
        int lesson_number
) {
}
