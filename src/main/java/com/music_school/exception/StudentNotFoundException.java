package com.music_school.exception;

public class StudentNotFoundException extends RuntimeException{
    private final int student_id;

    public StudentNotFoundException(int student_id) {
        this.student_id = student_id;
    }

    @Override
    public String getMessage() {
        return "Group with id = " + student_id + " not found";
    }
}
