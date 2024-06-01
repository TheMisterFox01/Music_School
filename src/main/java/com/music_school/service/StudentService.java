package com.music_school.service;

import com.music_school.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents(int group_id);
    Student getStudent(int student_id);
    void createStudent(String first_name, String second_name);

    void updateStudent(int student_id, String first_name, String second_name);
}
