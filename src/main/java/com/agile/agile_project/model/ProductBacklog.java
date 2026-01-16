package com.agile.agile_project.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class ProductBacklog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL)
    private List<UserStory> userStories;
}
