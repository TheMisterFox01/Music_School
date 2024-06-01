package com.music_school.repository;

import com.music_school.model.Student;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    List<Student> getStudentsByGroupId(int group_id);
    Optional<Student> getStudentById(int student_id);
    void insertStudent(String first_name, String second_name);
    void updateStudentById(int student_id, String first_name, String second_name);
}
