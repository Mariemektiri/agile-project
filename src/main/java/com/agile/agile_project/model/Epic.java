package com.agile.agile_project.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @OneToMany(mappedBy = "epic", cascade = CascadeType.ALL)
    private List<UserStory> userStories;

    // constructors, getters, setters
}
