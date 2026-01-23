package com.agile.agile_project.exception;

public class EpicNotFoundException extends RuntimeException {
    public EpicNotFoundException(Long id) {
        super("Epic not found with id " + id);
    }
}
