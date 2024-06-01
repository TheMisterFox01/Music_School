package com.music_school.controller;


import com.music_school.model.Group;
import com.music_school.model.GroupRequest;
import com.music_school.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public Group getGroup(@RequestBody GroupRequest request) {
        return groupService.getGroup(request.group_id());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@RequestBody GroupRequest request) {
        groupService.createGroup(
                request.teacher_id()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGroup(@RequestBody GroupRequest request) {
        groupService.updateGroup(
                request.teacher_id(),
                request.group_id()
        );
    }

    @DeleteMapping
    public void deleteGroup(@RequestBody GroupRequest request) {
        groupService.deleteGroup(request.group_id());
    }
}
