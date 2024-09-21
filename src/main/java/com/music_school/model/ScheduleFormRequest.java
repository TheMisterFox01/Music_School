package com.music_school.model;

import java.sql.Timestamp;

public record ScheduleFormRequest(
        Integer classId,
        Integer groupId,
        Timestamp date,
        Integer lessonNumber,
        String teacherLastName,
        String teacherFirstName,
        String token
) {
}
