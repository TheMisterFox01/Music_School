package com.music_school.controller;


import com.music_school.model.Group;
import com.music_school.model.GroupRequest;
import com.music_school.model.Teacher;
import com.music_school.model.TeacherRequest;
import com.music_school.service.GroupService;
import com.music_school.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public Teacher getTeacher(@RequestBody TeacherRequest request) {
        return teacherService.getTeacher(request.teacher_id());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeacher(@RequestBody TeacherRequest request) {
        teacherService.createTeacher(
                request.first_name(),
                request.second_name()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTeacher(@RequestBody TeacherRequest request) {
        teacherService.updateTeacher(
                request.teacher_id(),
                request.first_name(),
                request.second_name()
        );
    }

    @DeleteMapping
    public void deleteTeacher(@RequestBody TeacherRequest request) {
        teacherService.deleteTeacher(request.teacher_id());
    }
}
