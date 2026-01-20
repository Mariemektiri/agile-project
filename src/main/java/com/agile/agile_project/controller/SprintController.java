package com.agile.agile_project.controller;

import com.agile.agile_project.model.Sprint;
import com.agile.agile_project.service.SprintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sprints")
public class SprintController {

    private final SprintService service;

    public SprintController(SprintService service) {
        this.service = service;
    }

    @PostMapping
    public Sprint create(@RequestBody Sprint sprint) {
        return service.save(sprint);
    }

    @GetMapping
    public List<Sprint> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Sprint getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
