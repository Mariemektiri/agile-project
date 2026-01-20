package com.agile.agile_project.service.Impl;

import com.agile.agile_project.model.SprintBacklog;
import com.agile.agile_project.repository.SprintBacklogRepository;
import com.agile.agile_project.service.SprintBacklogService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SprintBacklogServiceImpl implements SprintBacklogService {

    private final SprintBacklogRepository repository;

    public SprintBacklogServiceImpl(SprintBacklogRepository repository) {
        this.repository = repository;
    }

    @Override
    public SprintBacklog save(SprintBacklog sb) {
        return repository.save(sb);
    }

    @Override
    public SprintBacklog getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("SprintBacklog not found"));
    }

    @Override
    public List<SprintBacklog> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
