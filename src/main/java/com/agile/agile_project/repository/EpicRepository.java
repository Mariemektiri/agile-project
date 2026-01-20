package com.agile.agile_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.agile_project.model.Epic;

public interface EpicRepository extends JpaRepository<Epic, Long> {
}

