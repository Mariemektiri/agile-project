package com.agile.agile_project.service.Impl;

import com.agile.agile_project.exception.EpicNotFoundException;
import com.agile.agile_project.model.Epic;
import com.agile.agile_project.repository.EpicRepository;
import com.agile.agile_project.service.EpicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpicServiceImpl implements EpicService {

    private final EpicRepository epicRepository;

    public EpicServiceImpl(EpicRepository epicRepository) {
        this.epicRepository = epicRepository;
    }

    @Override
    public Epic save(Epic epic) {
        return epicRepository.save(epic);
    }

    @Override
    public Epic getById(Long id) {
        return epicRepository.findById(id)
                .orElseThrow(() -> new EpicNotFoundException(id));
    }

    @Override
    public List<Epic> getAll() {
        return epicRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!epicRepository.existsById(id)) {
            throw new EpicNotFoundException(id);
        }
        epicRepository.deleteById(id);
    }
}
