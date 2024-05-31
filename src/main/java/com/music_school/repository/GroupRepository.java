package com.music_school.repository;

import com.music_school.model.Group;

import java.util.Optional;

public interface GroupRepository {

    Optional<Group> getGroupById(int id);

    void insertGroup(int teacher_id);
    void updateGroupById(int teacher_id, int id);
    void deleteGroupById(int id);
}
