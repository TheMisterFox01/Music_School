package com.music_school.repository;

import com.music_school.model.Class;

import java.util.Optional;

public interface ClassRepository {

    Optional<Class> getClassById(int id);

    void insertClass(int id, int size);
    void updateClassById(int id, int size);
    void deleteClassById(int id);
}
