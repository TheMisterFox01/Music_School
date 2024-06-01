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

    @GetMapping
    public Class getClass(@RequestBody ClassRequest request) {
        return classService.getClass(request.class_id());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClass(@RequestBody ClassRequest request) {
        classService.createClass(
                request.class_id(),
                request.size()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateClass(@RequestBody ClassRequest request) {
        classService.updateClass(
                request.class_id(),
                request.size()
        );
    }

    @DeleteMapping
    public void deleteClass(@RequestBody ClassRequest request) {
        classService.deleteClass(request.class_id());
    }
}
