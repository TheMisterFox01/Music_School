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

    @GetMapping(value = "/get")
    public Group getGroup(@RequestBody GroupRequest request) {
        return groupService.getGroup(request.groupId());
    }

    @PostMapping(value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@RequestBody GroupRequest request) {
        groupService.createGroup(
                request.teacherId()
        );
    }

    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGroup(@RequestBody GroupRequest request) {
        groupService.updateGroup(
                request.teacherId(),
                request.groupId()
        );
    }

    @DeleteMapping(value = "/delete")
    public void deleteGroup(@RequestBody GroupRequest request) {
        groupService.deleteGroup(request.groupId());
    }
}
