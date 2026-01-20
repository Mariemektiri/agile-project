package com.agile.agile_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.agile_project.model.SprintBacklog;

public interface SprintBacklogRepository extends JpaRepository<SprintBacklog, Long> {
}

