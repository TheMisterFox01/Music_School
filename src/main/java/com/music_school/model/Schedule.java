package com.music_school.model;

import java.sql.Timestamp;

public record Schedule(
        int class_id,
        int group_id,
        Timestamp date,
        int lesson_number
) {
}
