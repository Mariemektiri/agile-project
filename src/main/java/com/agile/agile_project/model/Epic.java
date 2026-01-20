package com.agile.agile_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL)
    private List<UserStory> userStories;

    @ManyToOne
    @JoinColumn(name = "product_backlog_id")
    private ProductBacklog productBacklog;

    // constructeurs, getters, setters
}
