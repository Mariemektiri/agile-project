package com.agile.agile_project.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ProductBacklog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL)
    private List<UserStory> userStories;

    @OneToMany(mappedBy = "productBacklog", cascade = CascadeType.ALL)
    private List<Epic> epics;

    // Constructors
    public ProductBacklog() {}

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserStory> getUserStories() {
        return userStories;
    }

    public void setUserStories(List<UserStory> userStories) {
        this.userStories = userStories;
    }

    public List<Epic> getEpics() {
        return epics;
    }

    public void setEpics(List<Epic> epics) {
        this.epics = epics;
    }
}
