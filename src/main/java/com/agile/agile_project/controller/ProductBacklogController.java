package com.agile.agile_project.controller;

import com.agile.agile_project.model.ProductBacklog;
import com.agile.agile_project.service.ProductBacklogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-backlogs")
public class ProductBacklogController {

    private final ProductBacklogService service;

    public ProductBacklogController(ProductBacklogService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('PO')")
    @PostMapping
    public ProductBacklog create(@RequestBody ProductBacklog pb) {
        return service.save(pb);
    }

    @PreAuthorize("hasAnyRole('PO','SCRUM_MASTER')")
    @GetMapping
    public List<ProductBacklog> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasAnyRole('PO','SCRUM_MASTER')")
    @GetMapping("/{id}")
    public ProductBacklog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PreAuthorize("hasRole('PO')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

