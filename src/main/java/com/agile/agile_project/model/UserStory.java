package com.agile.agile_project.model;

import com.agile.agile_project.model.enums.UserStoryStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private UserStoryStatus status;

    @ManyToOne
    @JoinColumn(name = "epic_id")
    private Epic epic;

    @ManyToOne
    @JoinColumn(name = "product_backlog_id")
    private ProductBacklog productBacklog;

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
