package com.music_school.repository;


import com.music_school.model.Teacher;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface TeacherRepository {

    Optional<Teacher> getTeacherById(int id);

    void insertTeacher(String first_name, String second_name);
    void updateTeacherById(int id, String first_name, String second_name);
    void deleteTeacherById(int id);
}
