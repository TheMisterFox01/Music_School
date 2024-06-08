package com.music_school.service;

import com.music_school.model.Schedule;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getSchedule();

    List<Schedule> formNewSchedule();

}
