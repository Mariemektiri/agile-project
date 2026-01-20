package com.agile.agile_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.agile_project.model.ProductBacklog;

public interface ProductBacklogRepository extends JpaRepository<ProductBacklog, Long> {
}
