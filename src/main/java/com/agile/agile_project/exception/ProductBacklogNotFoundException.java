package com.agile.agile_project.exception;

public class ProductBacklogNotFoundException extends RuntimeException {
    public ProductBacklogNotFoundException(Long id) {
        super("Product Backlog not found with id " + id);
    }
}
