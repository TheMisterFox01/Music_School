package com.music_school.repository;

import com.music_school.model.Schedule;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    List<Schedule> getSchedule();

    void formNewSchedule();
}
