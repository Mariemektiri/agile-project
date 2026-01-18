package com.agile.agile_project.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class SprintBacklog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @OneToMany(mappedBy = "sprintBacklog", cascade = CascadeType.ALL)
    private List<UserStory> userStories;

    @OneToMany(mappedBy = "sprintBacklog", cascade = CascadeType.ALL)
    private List<Task> tasks;

    // constructeurs, getters, setters
}
