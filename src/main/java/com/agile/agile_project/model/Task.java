package com.agile.agile_project.model;

import com.agile.agile_project.model.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;


    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "user_story_id")
    private UserStory userStory;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;   // <-- nouvelle relation

    @ManyToOne
    @JoinColumn(name = "sprint_backlog_id")
    private SprintBacklog sprintBacklog;

    // constructeurs, getters, setters
}
