package com.music_school.service;

import com.music_school.model.Schedule;
import com.music_school.model.ScheduleFormRequest;
import com.music_school.model.ScheduleRequest;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getSchedule(ScheduleRequest request);

    void formNewSchedule(ScheduleFormRequest request);

}
