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

    @GetMapping("/get")
    public Group getGroup(@RequestParam int group_id) {
        return groupService.getGroup(group_id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGroup(@RequestBody GroupRequest request) {
        groupService.createGroup(
                request.teacher_id()
        );
    }

    @PutMapping(value = "/{group_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGroup(
            @RequestBody GroupRequest request,
            @PathVariable int group_id
    ) {
        groupService.updateGroup(
                request.teacher_id(),
                group_id
        );
    }

    @DeleteMapping(value = "/{group_id}")
    public void deleteGroup(@PathVariable int group_id) {
        groupService.deleteGroup(group_id);
    }
}
