package com.agile.agile_project.service;

import com.agile.agile_project.model.Task;
import com.agile.agile_project.model.enums.TaskStatus;

import java.util.List;

public interface TaskService extends CrudService<Task, Long> {

    Task assignToDeveloper(Long taskId, Long devId);
    Task changeStatus(Long id, TaskStatus status);
}
