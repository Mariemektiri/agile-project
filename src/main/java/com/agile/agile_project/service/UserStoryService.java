package com.agile.agile_project.service;

import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.MoscowPriority;
import com.agile.agile_project.model.enums.UserStoryStatus;

public interface UserStoryService extends CrudService<UserStory, Long> {
    UserStory changeStatus(Long id, UserStoryStatus status);

    UserStory assignToSprint(Long userStoryId, Long sprintId, Long sprintBacklogId);

    UserStory changePriority(Long id, int priority);

    UserStory changeMoscowPriority(Long id, MoscowPriority priority);


}