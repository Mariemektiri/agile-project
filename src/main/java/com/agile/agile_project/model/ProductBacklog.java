package com.agile.agile_project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class ProductBacklog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL)
    private List<UserStory> userStories;

    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL)
    private List<Epic> epics;

    // constructeurs, getters, setters
}
