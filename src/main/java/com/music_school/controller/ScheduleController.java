package com.music_school.controller;

import com.music_school.model.*;
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
    public List<Schedule> getSchedule(@RequestBody ScheduleRequest request) {
        return scheduleService.getSchedule(request);
    }

    @GetMapping(value = "/new")
    public void formSchedule(@RequestBody ScheduleFormRequest request) {
        scheduleService.formNewSchedule(request);
    }

}
