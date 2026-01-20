package com.agile.agile_project.service.Impl;

import com.agile.agile_project.model.Task;
import com.agile.agile_project.model.enums.TaskStatus;
import com.agile.agile_project.repository.TaskRepository;
import com.agile.agile_project.service.TaskService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task save(Task task) {
        return repository.save(task);
    }

    @Override
    public Task getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Task changeStatus(Long id, TaskStatus status) {
        Task t = getById(id);
        t.setStatus(status);
        return repository.save(t);
    }
}
