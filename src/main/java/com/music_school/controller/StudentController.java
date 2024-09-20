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
        return studentService.getStudents(request.groupId());
    }

    @GetMapping(value = "/get")
    public Student getStudent(@RequestBody StudentRequest request) {
        return studentService.getStudent(request.studentId());
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentRequest request) {
        studentService.createStudent(
                request.firstName(),
                request.secondName()
        );
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStudent(@RequestBody StudentRequest request) {
        studentService.updateStudent(
                request.studentId(),
                request.firstName(),
                request.secondName()
        );
    }
}
