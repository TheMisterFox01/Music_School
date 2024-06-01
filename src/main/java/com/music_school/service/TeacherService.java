package com.music_school.service;

import com.music_school.model.Teacher;

public interface TeacherService {

    Teacher getTeacher(int id);

    void createTeacher(String first_name, String second_name);
    void updateTeacher(int id, String first_name, String second_name);
    void deleteTeacher(int id);
}
