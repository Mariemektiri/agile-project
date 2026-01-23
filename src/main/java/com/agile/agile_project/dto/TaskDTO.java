package com.agile.agile_project.dto;

import com.agile.agile_project.model.enums.TaskStatus;

public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;

    // Relations → uniquement des IDs
    private Long userStoryId;
    private Long developerId;
    private Long sprintBacklogId;

    // ✅ Constructeur vide (obligatoire)
    public TaskDTO() {
    }

    // ✅ Constructeur complet (pratique pour le mapper)
    public TaskDTO(Long id, String title, String description, TaskStatus status,
                   Long userStoryId, Long developerId, Long sprintBacklogId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.userStoryId = userStoryId;
        this.developerId = developerId;
        this.sprintBacklogId = sprintBacklogId;
    }

    // ✅ Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Long getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(Long userStoryId) {
        this.userStoryId = userStoryId;
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public Long getSprintBacklogId() {
        return sprintBacklogId;
    }

    public void setSprintBacklogId(Long sprintBacklogId) {
        this.sprintBacklogId = sprintBacklogId;
    }
}
