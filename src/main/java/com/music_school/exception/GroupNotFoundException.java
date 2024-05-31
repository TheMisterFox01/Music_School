package com.music_school.exception;

public class GroupNotFoundException extends RuntimeException{

    private final int group_id;

    public GroupNotFoundException(int group_id) {
        this.group_id = group_id;
    }

    @Override
    public String getMessage() {
        return "Group with id = " + group_id + " not found";
    }
}
