package com.agile.agile_project.model;

import com.agile.agile_project.model.enums.UserStoryStatus;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private int priority;                 // nouvelle exigence
    private String acceptanceCriteria;    // nouvelle exigence

    @Enumerated(EnumType.STRING)
    private UserStoryStatus status;

    @ManyToOne
    @JoinColumn(name = "epic_id")
    private Epic epic;

    @ManyToOne
    @JoinColumn(name = "product_backlog_id")
    private ProductBacklog productBacklog;

    @ManyToOne
    @JoinColumn(name = "sprint_backlog_id")
    private SprintBacklog sprintBacklog;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL)
    private List<Task> tasks;

    // constructeurs, getters, setters
}
