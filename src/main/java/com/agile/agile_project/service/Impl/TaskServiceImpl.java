package com.agile.agile_project.service.Impl;

import com.agile.agile_project.model.Task;
import com.agile.agile_project.model.User;
import com.agile.agile_project.model.enums.Role;
import com.agile.agile_project.model.enums.TaskStatus;
import com.agile.agile_project.repository.TaskRepository;
import com.agile.agile_project.repository.UserRepository;
import com.agile.agile_project.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
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

    @Transactional
    public Task assignToDeveloper(Long taskId, Long devId) {
        Task task = repository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User dev = userRepository.findById(devId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (dev.getRole() != Role.DEV) {
            throw new RuntimeException("User is not a developer");
        }

        task.setDeveloper(dev);
        return repository.save(task);
    }


    @Override
    public Task changeStatus(Long id, TaskStatus status) {
        Task t = getById(id);
        t.setStatus(status);
        return repository.save(t);
    }
}
