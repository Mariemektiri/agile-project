package com.agile.agile_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.agile_project.model.UserStory;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {
}

