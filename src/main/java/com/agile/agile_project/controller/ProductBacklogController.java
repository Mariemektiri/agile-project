package com.agile.agile_project.controller;

import com.agile.agile_project.model.ProductBacklog;
import com.agile.agile_project.service.ProductBacklogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productbacklogs")
public class ProductBacklogController {

    private final ProductBacklogService service;

    public ProductBacklogController(ProductBacklogService service) {
        this.service = service;
    }

    @PostMapping
    public ProductBacklog create(@RequestBody ProductBacklog pb) {
        return service.save(pb);
    }

    @GetMapping
    public List<ProductBacklog> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductBacklog getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

