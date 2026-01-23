package com.agile.agile_project.exception;

public class UserStoryNotFoundException extends RuntimeException {
    public UserStoryNotFoundException(Long id) {
        super("UserStory avec id " + id + " introuvable");
    }
}
