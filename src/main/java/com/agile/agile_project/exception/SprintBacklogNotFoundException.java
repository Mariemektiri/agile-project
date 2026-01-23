package com.agile.agile_project.exception;

public class SprintBacklogNotFoundException extends RuntimeException {
    public SprintBacklogNotFoundException(Long id) {
        super("Sprint Backlog not found with id " + id);
    }
}
