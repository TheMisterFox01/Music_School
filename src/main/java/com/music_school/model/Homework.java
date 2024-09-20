package com.music_school.model;

import java.sql.Timestamp;

public record Homework(
        Integer homeworkId,
        Integer studentId,
        Timestamp dateUntil,
        Integer grade
) {
}
