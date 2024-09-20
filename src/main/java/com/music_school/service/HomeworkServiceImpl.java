package com.music_school.service;

import com.music_school.exception.HomeworkNotFoundException;
import com.music_school.model.Homework;
import com.music_school.repository.HomeworkRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;


@Primary
@Service
public class HomeworkServiceImpl implements HomeworkService{

    private final HomeworkRepository homeworkRepository;

    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @Override
    public List<Homework> getHomeworks(int student_id) {
        return homeworkRepository.getHomeworksByStudentId(student_id);
    }

    @Override
    public Homework getHomework(int homework_id) {
        return homeworkRepository.getHomeworkById(homework_id)
                .orElseThrow(() -> new HomeworkNotFoundException(homework_id));
    }

    @Override
    public void createHomework(int student_id, Timestamp date_until) {
        homeworkRepository.insertHomework(student_id,date_until);
    }

    @Override
    public void updateHomework(int grade, int homework_id) {
        var homework = homeworkRepository.getHomeworkById(homework_id)
                .orElseThrow(() -> new HomeworkNotFoundException(homework_id));
        homeworkRepository.updateHomeworkById(grade, homework.homeworkId());
    }
}
