package com.music_school.controller;

import com.music_school.model.Homework;
import com.music_school.model.HomeworkRequest;
import com.music_school.model.Schedule;
import com.music_school.service.HomeworkService;
import com.music_school.service.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = "/get")
    public List<Schedule> getHomeworks(@RequestBody HomeworkRequest request) {
        return scheduleService.getSchedule();
    }

    @GetMapping(value = "/new")
    public List<Schedule> getHomework(@RequestBody HomeworkRequest request) {
        return scheduleService.formNewSchedule();
    }

}
