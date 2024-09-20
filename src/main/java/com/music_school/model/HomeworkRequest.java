package com.music_school.model;

import java.sql.Timestamp;

public record HomeworkRequest(
        Integer homeworkId,
        Integer studentId,
        Integer grade,
        Timestamp dateUntil
) {
}
