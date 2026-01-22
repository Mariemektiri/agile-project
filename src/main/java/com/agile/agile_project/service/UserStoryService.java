package com.agile.agile_project.service;

import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.UserStoryStatus;

import java.util.List;

public interface UserStoryService extends CrudService<UserStory, Long> {
    UserStory changeStatus(Long id, UserStoryStatus status);

    UserStory assignToSprint(Long userStoryId, Long sprintId, Long sprintBacklogId);

}
