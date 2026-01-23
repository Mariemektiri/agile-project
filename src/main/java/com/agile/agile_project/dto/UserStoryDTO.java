package com.agile.agile_project.dto;

import com.agile.agile_project.model.enums.UserStoryStatus;
import com.agile.agile_project.model.enums.MoscowPriority;
import java.util.List;

public class UserStoryDTO {

    private Long id;
    private String title;
    private String description;

    // Priorisation
    private int priority;               // priorité numérique
    private MoscowPriority moscowPriority;

    private String acceptanceCriteria;
    private UserStoryStatus status;

    // Relations → seulement des IDs
    private Long epicId;
    private Long productBacklogId;
    private Long sprintId;
    private Long sprintBacklogId;
    private List<Long> taskIds;

    // ✅ Constructeur vide (obligatoire)
    public UserStoryDTO() {
    }

    // ✅ Constructeur complet
    public UserStoryDTO(Long id, String title, String description,
                        int priority, MoscowPriority moscowPriority,
                        String acceptanceCriteria, UserStoryStatus status,
                        Long epicId, Long productBacklogId,
                        Long sprintId, Long sprintBacklogId,
                        List<Long> taskIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.moscowPriority = moscowPriority;
        this.acceptanceCriteria = acceptanceCriteria;
        this.status = status;
        this.epicId = epicId;
        this.productBacklogId = productBacklogId;
        this.sprintId = sprintId;
        this.sprintBacklogId = sprintBacklogId;
        this.taskIds = taskIds;
    }

    // ✅ Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }

    public MoscowPriority getMoscowPriority() { return moscowPriority; }
    public void setMoscowPriority(MoscowPriority moscowPriority) {
        this.moscowPriority = moscowPriority;
    }

    public String getAcceptanceCriteria() { return acceptanceCriteria; }
    public void setAcceptanceCriteria(String acceptanceCriteria) {
        this.acceptanceCriteria = acceptanceCriteria;
    }

    public UserStoryStatus getStatus() { return status; }
    public void setStatus(UserStoryStatus status) { this.status = status; }

    public Long getEpicId() { return epicId; }
    public void setEpicId(Long epicId) { this.epicId = epicId; }

    public Long getProductBacklogId() { return productBacklogId; }
    public void setProductBacklogId(Long productBacklogId) {
        this.productBacklogId = productBacklogId;
    }

    public Long getSprintId() { return sprintId; }
    public void setSprintId(Long sprintId) { this.sprintId = sprintId; }

    public Long getSprintBacklogId() { return sprintBacklogId; }
    public void setSprintBacklogId(Long sprintBacklogId) {
        this.sprintBacklogId = sprintBacklogId;
    }

    public List<Long> getTaskIds() { return taskIds; }
    public void setTaskIds(List<Long> taskIds) { this.taskIds = taskIds; }
}
