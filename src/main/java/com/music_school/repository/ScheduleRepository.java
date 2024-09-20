package com.music_school.repository;

import com.music_school.model.Schedule;
import com.music_school.model.ScheduleRequest;

import java.util.List;

public interface ScheduleRepository {

    List<Schedule> getSchedule(ScheduleRequest request);

    void formNewSchedule(Schedule schedule);
}
