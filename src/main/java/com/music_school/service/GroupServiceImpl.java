package com.music_school.service;

import com.music_school.exception.GroupNotFoundException;
import com.music_school.model.Group;
import com.music_school.repository.GroupRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class GroupServiceImpl implements GroupService{

    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Group getGroup(int id) {
        return groupRepository.getGroupById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
    }

    @Override
    public void createGroup(int teacherId) {
        groupRepository.insertGroup(teacherId);
    }

    @Override
    public void updateGroup(int teacherId, int id) {
        var group = groupRepository.getGroupById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
        groupRepository.updateGroupById(teacherId, group.groupId());
    }

    @Override
    public void deleteGroup(int id) {
        var group = groupRepository.getGroupById(id)
                .orElseThrow(() -> new GroupNotFoundException(id));
        groupRepository.deleteGroupById(group.groupId());
    }
}
