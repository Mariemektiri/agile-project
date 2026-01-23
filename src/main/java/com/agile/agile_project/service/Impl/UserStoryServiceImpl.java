package com.agile.agile_project.service.Impl;

import com.agile.agile_project.event.UserStoryStatusChangedEvent;
import com.agile.agile_project.exception.UserStoryNotFoundException;
import com.agile.agile_project.model.Sprint;
import com.agile.agile_project.model.SprintBacklog;
import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.MoscowPriority;
import com.agile.agile_project.model.enums.UserStoryStatus;
import com.agile.agile_project.repository.UserStoryRepository;
import com.agile.agile_project.service.UserStoryService;
import com.agile.agile_project.repository.SprintRepository;
import com.agile.agile_project.repository.SprintBacklogRepository;
import com.agile.agile_project.strategy.moscow.MoscowPriorityStrategy;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class UserStoryServiceImpl implements UserStoryService {

    private final UserStoryRepository repository;
    private final SprintRepository sprintRepository;
    private final SprintBacklogRepository sprintBacklogRepository;
    private final Map<String, MoscowPriorityStrategy> strategies;
    private final ApplicationEventPublisher eventPublisher;

    public UserStoryServiceImpl(UserStoryRepository repository, SprintRepository sprintRepository,
                                SprintBacklogRepository sprintBacklogRepository, Map<String, MoscowPriorityStrategy> strategies, ApplicationEventPublisher eventPublisher) {
        this.repository = repository;
        this.sprintRepository = sprintRepository;
        this.sprintBacklogRepository = sprintBacklogRepository;
        this.strategies = strategies;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public UserStory save(UserStory us) {
        return repository.save(us);
    }

    @Override
    public UserStory getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserStory not found"));
    }

    @Override
    public List<UserStory> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserStory changeStatus(Long id, UserStoryStatus status) {
        UserStory us = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserStory not found"));

        us.setStatus(status);
        UserStory saved = repository.save(us);

        // 🔔 NOTIFICATION
        eventPublisher.publishEvent(
                new UserStoryStatusChangedEvent(id, status)
        );

        return saved;
    }
    @Override
    public UserStory assignToSprint(Long userStoryId, Long sprintId, Long sprintBacklogId) {
        UserStory userStory = repository.findById(userStoryId)
                .orElseThrow(() -> new RuntimeException("UserStory not found"));

        Sprint sprint = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new RuntimeException("Sprint not found"));

        SprintBacklog sprintBacklog = sprintBacklogRepository.findById(sprintBacklogId)
                .orElseThrow(() -> new RuntimeException("SprintBacklog not found"));

        userStory.setSprint(sprint);
        userStory.setSprintBacklog(sprintBacklog);

        return repository.save(userStory);
    }

    public UserStory changePriority(Long id, int priority) {
        UserStory us = repository.findById(id)
                .orElseThrow(() -> new UserStoryNotFoundException(id));
        us.setPriority(priority);
        return repository.save(us);
    }

    @Override
    public UserStory changeMoscowPriority(Long id, MoscowPriority priority) {
        UserStory us = repository.findById(id)
                .orElseThrow(() -> new UserStoryNotFoundException(id));

        MoscowPriorityStrategy strategy =
                strategies.get(priority.name());

        if (strategy == null) {
            throw new IllegalArgumentException("Invalid MoSCoW priority");
        }

        strategy.apply(us);
        return repository.save(us);
    }



}


