package com.agile.agile_project.controller;

import com.agile.agile_project.model.Task;
import com.agile.agile_project.model.enums.TaskStatus;
import com.agile.agile_project.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task create(@RequestBody Task task) {
        return service.save(task);
    }

    @GetMapping
    public List<Task> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public Task changeStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status) {
        return service.changeStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
