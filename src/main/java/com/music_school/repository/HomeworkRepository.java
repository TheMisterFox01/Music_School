package com.music_school.repository;

import com.music_school.model.Homework;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface HomeworkRepository {
    List<Homework> getHomeworkByStudentId(int student_id);
    Optional<Homework> getHomeworkById(int homework_id);

    void insertHomework(int student_id, Timestamp date_until);
    void updateHomeworkById(int grade, int homework_id);
}
