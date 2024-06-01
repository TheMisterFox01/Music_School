package com.music_school.service;

import com.music_school.exception.ClassNotFoundException;
import com.music_school.exception.GroupNotFoundException;
import com.music_school.model.Class;
import com.music_school.repository.ClassRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ClassServiceImpl implements ClassService{

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Class getClass(int id){
        return classRepository.getClassById(id)
                .orElseThrow(() -> new ClassNotFoundException(id));
    }

    @Override
    public void createClass(int id, int size) {
        classRepository.insertClass(id, size);
    }

    @Override
    public void updateClass(int id, int size){
        var _class = classRepository.getClassById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
        classRepository.updateClassById(_class.class_id(), size);
    }

    @Override
    public void deleteClass(int id){
        var _class = classRepository.getClassById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
        classRepository.deleteClassById(_class.class_id());
    }
}
