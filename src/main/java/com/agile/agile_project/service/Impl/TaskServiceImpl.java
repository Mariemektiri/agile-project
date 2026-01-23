package com.agile.agile_project.service.Impl;

import com.agile.agile_project.exception.BusinessRuleException;
import com.agile.agile_project.exception.TaskNotFoundException;
import com.agile.agile_project.exception.UserNotFoundException;
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
@Transactional
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
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @Override
    public List<Task> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        repository.deleteById(id);
    }

    @Override
    public Task changeStatus(Long id, TaskStatus status) {
        Task task = getById(id);
        task.setStatus(status);
        return repository.save(task);
    }

    @Override
    public Task assignToDeveloper(Long taskId, Long devId) {

        Task task = repository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        User dev = userRepository.findById(devId)
                .orElseThrow(() -> new UserNotFoundException(devId));

        // 🔴 Business rule
        if (dev.getRole() != Role.DEV) {
            throw new BusinessRuleException(
                    "Only users with DEV role can be assigned to tasks"
            );
        }

        task.setDeveloper(dev);
        return repository.save(task);
    }
}
