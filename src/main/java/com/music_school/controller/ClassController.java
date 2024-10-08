package com.music_school.controller;


import com.music_school.model.ClassRequest;
import com.music_school.model.Class;
import com.music_school.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping(value = "/get")
    public Class getClass(@RequestBody ClassRequest request) {
        return classService.getClass(request.classId());
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClass(@RequestBody ClassRequest request) {
        classService.createClass(
                request.classId(),
                request.size()
        );
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClass(@RequestBody ClassRequest request) {
        classService.updateClass(
                request.classId(),
                request.size()
        );
    }

    @DeleteMapping(value = "/delete")
    public void deleteClass(@RequestBody ClassRequest request) {
        classService.deleteClass(request.classId());
    }
}
