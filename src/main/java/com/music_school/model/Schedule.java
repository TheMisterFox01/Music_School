package com.music_school.model;

import java.sql.Timestamp;
public record Schedule(
        Integer classId,
        Integer groupId,
        Timestamp date,
        Integer lessonNumber,
        String teacherLastName,
        String teacherFirstName
) {
}
