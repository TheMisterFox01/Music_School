package com.music_school.service;


import com.music_school.exception.TeacherNotFoundException;
import com.music_school.model.Teacher;
import com.music_school.repository.TeacherRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher getTeacher(int id){
        return teacherRepository.getTeacherById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    @Override
    public void createTeacher(String first_name, String second_name){
        teacherRepository.insertTeacher(first_name,second_name);
    }

    @Override
    public void updateTeacher(int id, String first_name, String second_name){
        var teacher = teacherRepository.getTeacherById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
        teacherRepository.updateTeacherById(teacher.teacher_id(),first_name,second_name);
    }

    @Override
    public void deleteTeacher(int id){
        var teacher = teacherRepository.getTeacherById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
        teacherRepository.deleteTeacherById(teacher.teacher_id());
    }
}
