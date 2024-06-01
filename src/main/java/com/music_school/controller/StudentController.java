package com.music_school.controller;


import com.music_school.model.Student;
import com.music_school.model.StudentRequest;
import com.music_school.repository.StudentRepository;
import com.music_school.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/all")
    public List<Student> getSudents(@RequestBody StudentRequest request) {
        return studentService.getStudents(request.group_id());
    }

    @GetMapping
    public Student getStudent(@RequestBody StudentRequest request) {
        return studentService.getStudent(request.student_id());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentRequest request) {
        studentService.createStudent(
                request.first_name(),
                request.second_name()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudent(@RequestBody StudentRequest request) {
        studentService.updateStudent(
                request.student_id(),
                request.first_name(),
                request.second_name()
        );
    }
}
