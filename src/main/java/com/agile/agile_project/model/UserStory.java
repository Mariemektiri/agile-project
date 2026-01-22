package com.agile.agile_project.model;

import com.agile.agile_project.model.enums.MoscowPriority;
import com.agile.agile_project.model.enums.UserStoryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

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

    @Enumerated(EnumType.STRING)
    private MoscowPriority moscowPriority;


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

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;



    // constructeurs, getters, setters
}
