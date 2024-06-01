package com.music_school.exception;

public class ClassNotFoundException extends RuntimeException{
    private final int class_id;

    public ClassNotFoundException(int class_id) {
        this.class_id = class_id;
    }

    @Override
    public String getMessage() {
        return "Class with id = " + class_id + " not found";
    }
}
