package com.agile.agile_project.dto;

public class AssignUserStoryToSprintRequest {
    private Long sprintId;
    private Long sprintBacklogId;

    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long sprintId) {
        this.sprintId = sprintId;
    }

    public Long getSprintBacklogId() {
        return sprintBacklogId;
    }

    public void setSprintBacklogId(Long sprintBacklogId) {
        this.sprintBacklogId = sprintBacklogId;
    }
}
