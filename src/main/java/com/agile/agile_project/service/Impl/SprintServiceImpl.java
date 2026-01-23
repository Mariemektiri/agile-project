package com.agile.agile_project.service.Impl;

import com.agile.agile_project.exception.SprintNotFoundException;
import com.agile.agile_project.model.Sprint;
import com.agile.agile_project.repository.SprintRepository;
import com.agile.agile_project.service.SprintService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
                .orElseThrow(() -> new SprintNotFoundException(id));
    }

    @Override
    public List<Sprint> getAll() {
        return sprintRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!sprintRepository.existsById(id)) {
            throw new SprintNotFoundException(id);
        }
        sprintRepository.deleteById(id);
    }
}
