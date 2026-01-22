package com.agile.agile_project.controller;

import com.agile.agile_project.dto.AssignUserStoryToSprintRequest;
import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.MoscowPriority;
import com.agile.agile_project.model.enums.UserStoryStatus;
import com.agile.agile_project.service.UserStoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-stories")
public class UserStoryController {

    private final UserStoryService service;

    public UserStoryController(UserStoryService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('PO')")
    @PostMapping
    public UserStory create(@RequestBody UserStory us) {
        return service.save(us);
    }

    @PreAuthorize("hasAnyRole('PO','SCRUM_MASTER')")
    @GetMapping
    public List<UserStory> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasAnyRole('PO','SCRUM_MASTER')")
    @GetMapping("/{id}")
    public UserStory getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @PreAuthorize("hasRole('SCRUM_MASTER')")
    @PutMapping("/{id}/status")
    public UserStory changeStatus(
            @PathVariable Long id,
            @RequestParam UserStoryStatus status) {
        return service.changeStatus(id, status);
    }

    @PreAuthorize("hasRole('SCRUM_MASTER')")
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

    @PutMapping("/{id}/priority")
    @PreAuthorize("hasRole('PO')")
    public UserStory changePriority(
            @PathVariable Long id,
            @RequestParam int priority) {
        return service.changePriority(id, priority);
    }

    @PutMapping("/{id}/moscow")
    @PreAuthorize("hasRole('PO')")
    public UserStory changeMoscow(
            @PathVariable Long id,
            @RequestParam MoscowPriority priority) {
        return service.changeMoscowPriority(id, priority);
    }



    @PreAuthorize("hasRole('PO')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

