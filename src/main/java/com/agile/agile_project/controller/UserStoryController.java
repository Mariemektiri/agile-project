package com.agile.agile_project.controller;

import com.agile.agile_project.dto.AssignUserStoryToSprintRequest;
import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.UserStoryStatus;
import com.agile.agile_project.service.UserStoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-stories")
public class UserStoryController {

    private final UserStoryService service;

    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    @PostMapping
    public UserStory create(@RequestBody UserStory us) {
        return service.save(us);
    }

    @GetMapping
    public List<UserStory> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UserStory getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public UserStory changeStatus(
            @PathVariable Long id,
            @RequestParam UserStoryStatus status) {
        return service.changeStatus(id, status);
    }

    @PutMapping("/{id}/assign-to-sprint")
    public UserStory assignToSprint(
            @PathVariable Long id,
            @RequestBody AssignUserStoryToSprintRequest request
    ) {
        return service.assignToSprint(
                id,
                request.getSprintId(),
                request.getSprintBacklogId()
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

