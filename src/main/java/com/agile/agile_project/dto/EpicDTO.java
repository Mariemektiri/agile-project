package com.agile.agile_project.dto;

import java.util.List;

public class EpicDTO {

    private Long id;
    private String title;
    private String description;

    // We only expose IDs, not full objects
    private Long productBacklogId;
    private List<Long> userStoryIds;

    // ✅ Constructors
    public EpicDTO() {}

    public EpicDTO(Long id, String title, String description,
                   Long productBacklogId, List<Long> userStoryIds) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.productBacklogId = productBacklogId;
        this.userStoryIds = userStoryIds;
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

    public Long getProductBacklogId() {
        return productBacklogId;
    }

    public void setProductBacklogId(Long productBacklogId) {
        this.productBacklogId = productBacklogId;
    }

    public List<Long> getUserStoryIds() {
        return userStoryIds;
    }

    public void setUserStoryIds(List<Long> userStoryIds) {
        this.userStoryIds = userStoryIds;
    }
}
