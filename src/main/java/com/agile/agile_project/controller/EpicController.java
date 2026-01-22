package com.agile.agile_project.controller;

import com.agile.agile_project.model.Epic;
import com.agile.agile_project.service.EpicService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/epics")
public class EpicController {

    private final EpicService epicService;

    public EpicController(EpicService epicService) {
        this.epicService = epicService;
    }



    @PreAuthorize("hasRole('PO')")
    @PostMapping
    public Epic create(@RequestBody Epic epic) {
        return epicService.save(epic);
    }

    @PreAuthorize("hasAnyRole('PO','SCRUM_MASTER')")
    @GetMapping
    public List<Epic> getAll() {
        return epicService.getAll();
    }

    @PreAuthorize("hasAnyRole('PO','SCRUM_MASTER')")
    @GetMapping("/{id}")
    public Epic getById(@PathVariable Long id) {
        return epicService.getById(id);
    }

    @PreAuthorize("hasRole('PO')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        epicService.delete(id);
    }
}
