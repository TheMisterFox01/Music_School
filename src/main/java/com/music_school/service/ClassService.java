package com.music_school.service;

import com.music_school.model.Class;

public interface ClassService {

    Class getClass(int id);

    void createClass(int id, int size);
    void updateClass(int id, int size);
    void deleteClass(int id);
}
