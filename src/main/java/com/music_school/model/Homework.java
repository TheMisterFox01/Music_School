package com.music_school.model;

import java.sql.Timestamp;

public record Homework(
        int homework_id,
        int student_id,
        Timestamp date_until,
        int grade
) {
}
