package com.music_school.service;

import com.music_school.model.Group;

public interface GroupService {

    Group getGroup(int id);
    void createGroup(int teacher_id);
    void updateGroup(int teacher_id, int id);
    void deleteGroup(int id);
}
