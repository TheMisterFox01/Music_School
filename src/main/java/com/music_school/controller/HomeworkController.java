package com.music_school.controller;

import com.music_school.model.*;
import com.music_school.repository.HomeworkRepository;
import com.music_school.service.HomeworkService;
import com.music_school.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/homework")
public class HomeworkController {


    private final HomeworkService homeworkService;

    public HomeworkController(HomeworkService homeworkService) {
        this.homeworkService = homeworkService;
    }

    @GetMapping(value = "/all")
    public List<Homework> getHomeworks(@RequestBody HomeworkRequest request) {
        return homeworkService.getHomeworks(request.student_id());
    }

    @GetMapping
    public Homework getHomework(@RequestBody HomeworkRequest request) {
        return homeworkService.getHomework(request.homework_id());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createHomework(@RequestBody HomeworkRequest request) {
        homeworkService.createHomework(
                request.student_id(),
                request.date_until()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateHomework(@RequestBody HomeworkRequest request) {
        homeworkService.updateHomework(
                request.grade(),
                request.homework_id()
        );
    }
}
