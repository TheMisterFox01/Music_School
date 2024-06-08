package com.music_school.exception;

public class ScheduleCanNotBeCreatedException extends RuntimeException{

    @Override
    public String getMessage() {
        return "There is no class for group";
    }
}
