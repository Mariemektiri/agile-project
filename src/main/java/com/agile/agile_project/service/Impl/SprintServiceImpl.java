package com.agile.agile_project.service.Impl;

import com.agile.agile_project.model.Sprint;
import com.agile.agile_project.repository.SprintRepository;
import com.agile.agile_project.service.SprintService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements SprintService {

    private final SprintRepository sprintRepository;

    public SprintServiceImpl(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }

    @Override
    public Sprint save(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public Sprint getById(Long id) {
        return sprintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sprint not found"));
    }

    @Override
    public List<Sprint> getAll() {
        return sprintRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        sprintRepository.deleteById(id);
    }
}
