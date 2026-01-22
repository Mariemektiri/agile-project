package com.agile.agile_project.controller;

import com.agile.agile_project.model.SprintBacklog;
import com.agile.agile_project.service.SprintBacklogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sprint-backlogs")
public class SprintBacklogController {

    private final SprintBacklogService sprintBacklogService;

    public SprintBacklogController(SprintBacklogService sprintBacklogService) {
        this.sprintBacklogService = sprintBacklogService;
    }

    @PreAuthorize("hasRole('SCRUM_MASTER')")
    @PostMapping
    public SprintBacklog create(@RequestBody SprintBacklog sprintBacklog) {
        return sprintBacklogService.save(sprintBacklog);
    }

    @PreAuthorize("hasAnyRole('PO','SCRUM_MASTER')")
    @GetMapping
    public List<SprintBacklog> getAll() {
        return sprintBacklogService.getAll();
    }

    @PreAuthorize("hasAnyRole('PO','SCRUM_MASTER')")
    @GetMapping("/{id}")
    public SprintBacklog getById(@PathVariable Long id) {
        return sprintBacklogService.getById(id);
    }
}
