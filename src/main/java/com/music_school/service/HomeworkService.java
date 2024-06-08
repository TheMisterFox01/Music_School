package com.music_school.service;

import com.music_school.model.Homework;

import java.sql.Timestamp;
import java.util.List;

public interface HomeworkService {

    List<Homework> getHomeworks(int student_id);

    Homework getHomework(int homework_id);

    void createHomework(int student_id, Timestamp date_until);

    void updateHomework(int grade, int homework_id);
}
