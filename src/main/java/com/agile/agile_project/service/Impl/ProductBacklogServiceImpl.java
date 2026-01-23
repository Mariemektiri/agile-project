package com.agile.agile_project.service.Impl;

import com.agile.agile_project.model.ProductBacklog;
import com.agile.agile_project.repository.ProductBacklogRepository;
import com.agile.agile_project.service.ProductBacklogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductBacklogServiceImpl implements ProductBacklogService {

    private final ProductBacklogRepository repository;

    public ProductBacklogServiceImpl(ProductBacklogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductBacklog save(ProductBacklog pb) {
        return repository.save(pb);
    }

    @Override
    public ProductBacklog getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductBacklog not found"));
    }

    @Override
    public List<ProductBacklog> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

