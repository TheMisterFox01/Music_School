package com.music_school.exception;

public class TeacherNotFoundException extends RuntimeException{
    private final int teacher_id;

    public TeacherNotFoundException(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Override
    public String getMessage() {
        return "Teacher with id = " + teacher_id + " not found";
    }
}
