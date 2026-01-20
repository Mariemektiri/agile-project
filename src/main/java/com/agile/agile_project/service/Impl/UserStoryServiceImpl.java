package com.agile.agile_project.service.Impl;

import com.agile.agile_project.model.UserStory;
import com.agile.agile_project.model.enums.UserStoryStatus;
import com.agile.agile_project.repository.UserStoryRepository;
import com.agile.agile_project.service.UserStoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserStoryServiceImpl implements UserStoryService {

    private final UserStoryRepository repository;

    public UserStoryServiceImpl(UserStoryRepository repository) {
        this.repository = repository;
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
        UserStory us = getById(id);
        us.setStatus(status);
        return repository.save(us);
    }
}


