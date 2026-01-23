package com.agile.agile_project.exception;

public class SprintNotFoundException extends RuntimeException {
    public SprintNotFoundException(Long id) {
        super("Sprint not found with id " + id);
    }
}

