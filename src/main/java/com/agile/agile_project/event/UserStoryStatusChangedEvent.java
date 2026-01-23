package com.agile.agile_project.event;

import com.agile.agile_project.model.enums.UserStoryStatus;

public class UserStoryStatusChangedEvent {

    private final Long userStoryId;
    private final UserStoryStatus newStatus;

    public UserStoryStatusChangedEvent(Long userStoryId, UserStoryStatus newStatus) {
        this.userStoryId = userStoryId;
        this.newStatus = newStatus;
    }

    public Long getUserStoryId() {
        return userStoryId;
    }

    public UserStoryStatus getNewStatus() {
        return newStatus;
    }
}
