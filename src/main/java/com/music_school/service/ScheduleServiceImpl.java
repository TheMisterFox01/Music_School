package com.music_school.service;

import com.music_school.model.Schedule;
import com.music_school.repository.ScheduleRepository;
import com.music_school.repository.StudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<Schedule> getSchedule() {
        return scheduleRepository.getSchedule();
    }

    @Override
    public List<Schedule> formNewSchedule() {
        return scheduleRepository.getSchedule();
    }

}
