package com.music_school.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ScheduleRequest(
        Integer classId,
        Integer groupId,
        Integer lessonNumber,
        String teacherFirstName,
        String teacherLastName,
        Date date
) {
}
