package com.music_school.service;

import com.music_school.exception.HomeworkNotFoundException;
import com.music_school.model.Student;
import com.music_school.repository.StudentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Primary
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getStudents(int group_id){
        return studentRepository.getStudentsByGroupId(group_id);
    }

    @Override
    public Student getStudent(int student_id){
        return studentRepository.getStudentById(student_id)
                .orElseThrow(() -> new HomeworkNotFoundException(student_id));
    }

    @Override
    public void updateStudent(int student_id, String first_name, String second_name){
        var student = studentRepository.getStudentById(student_id)
                .orElseThrow(() -> new HomeworkNotFoundException(student_id));
        studentRepository.updateStudentById(student.studentId(),first_name,second_name);
    }

    @Override
    public void createStudent(String first_name, String second_name) {
        studentRepository.insertStudent(first_name,second_name);
    }
}
