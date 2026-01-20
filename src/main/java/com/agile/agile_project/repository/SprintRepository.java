package com.agile.agile_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.agile_project.model.Sprint;

public interface SprintRepository extends JpaRepository<Sprint, Long> {
}

