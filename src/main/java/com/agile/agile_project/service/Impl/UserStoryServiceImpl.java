package com.agile.agile_project.service.Impl;

import com.agile.agile_project.event.UserStoryStatusChangedEvent;
import com.agile.agile_project.exception.BusinessRuleException;
import com.agile.agile_project.exception.SprintBacklogNotFoundException;
import com.agile.agile_project.exception.SprintNotFoundException;
import com.agile.agile_project.exception.UserStoryNotFoundException;
import com.agile.agile_project.model.Sprint;
import com.agile.agile_project.model.SprintBacklog;
import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.MoscowPriority;
import com.agile.agile_project.model.enums.UserStoryStatus;
import com.agile.agile_project.repository.SprintBacklogRepository;
import com.agile.agile_project.repository.SprintRepository;
import com.agile.agile_project.repository.UserStoryRepository;
import com.agile.agile_project.service.UserStoryService;
import com.agile.agile_project.strategy.moscow.MoscowPriorityStrategy;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserStoryServiceImpl implements UserStoryService {

    private final UserStoryRepository repository;
    private final SprintRepository sprintRepository;
    private final SprintBacklogRepository sprintBacklogRepository;
    private final Map<String, MoscowPriorityStrategy> strategies;
    private final ApplicationEventPublisher eventPublisher;

    public UserStoryServiceImpl(
            UserStoryRepository repository,
            SprintRepository sprintRepository,
            SprintBacklogRepository sprintBacklogRepository,
            Map<String, MoscowPriorityStrategy> strategies,
            ApplicationEventPublisher eventPublisher) {

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
                .orElseThrow(() -> new UserStoryNotFoundException(id));
    }

    @Override
    public List<UserStory> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new UserStoryNotFoundException(id);
        }
        repository.deleteById(id);
    }

    // ================= OBSERVER PATTERN =================
    @Override
    public UserStory changeStatus(Long id, UserStoryStatus status) {

        UserStory us = getById(id);

        // 🔴 Business rule
        if (status == UserStoryStatus.DONE && us.getTasks().isEmpty()) {
            throw new BusinessRuleException(
                    "Impossible de passer à DONE sans tâches"
            );
        }

        us.setStatus(status);
        UserStory saved = repository.save(us);

        // 🔔 Notify observers
        eventPublisher.publishEvent(
                new UserStoryStatusChangedEvent(id, status)
        );

        return saved;
    }

    // ================= SPRINT ASSIGNMENT =================
    @Override
    public UserStory assignToSprint(Long userStoryId,
                                    Long sprintId,
                                    Long sprintBacklogId) {

        UserStory userStory = repository.findById(userStoryId)
                .orElseThrow(() -> new UserStoryNotFoundException(userStoryId));

        Sprint sprint = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new SprintNotFoundException(sprintId));

        SprintBacklog sprintBacklog = sprintBacklogRepository.findById(sprintBacklogId)
                .orElseThrow(() -> new SprintBacklogNotFoundException(sprintBacklogId));

        userStory.setSprint(sprint);
        userStory.setSprintBacklog(sprintBacklog);

        return repository.save(userStory);
    }

    // ================= SIMPLE PRIORITY =================
    @Override
    public UserStory changePriority(Long id, int priority) {
        UserStory us = getById(id);
        us.setPriority(priority);
        return repository.save(us);
    }

    // ================= STRATEGY PATTERN (MoSCoW) =================
    @Override
    public UserStory changeMoscowPriority(Long id, MoscowPriority priority) {

        UserStory us = getById(id);

        MoscowPriorityStrategy strategy = strategies.get(priority.name());
        if (strategy == null) {
            throw new BusinessRuleException("Invalid MoSCoW priority");
        }

        strategy.apply(us);
        return repository.save(us);
    }
}
