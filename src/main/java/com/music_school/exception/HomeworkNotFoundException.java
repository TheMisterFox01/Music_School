package com.music_school.exception;

public class HomeworkNotFoundException extends RuntimeException{
    private final int homework_id;

    public HomeworkNotFoundException(int homework_id) {
        this.homework_id = homework_id;
    }

    @Override
    public String getMessage() {
        return "Group with id = " + homework_id + " not found";
    }
}
