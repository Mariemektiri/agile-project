package com.agile.agile_project.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "sprint", cascade = CascadeType.ALL)
    private List<UserStory> userStories;

    @OneToOne(mappedBy = "sprint", cascade = CascadeType.ALL)
    private SprintBacklog sprintBacklog;
}

