package com.agile.agile_project.model;

import com.agile.agile_project.model.enums.Role;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;


    @Entity
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;
        private String email;
        private String password;

        @Enumerated(EnumType.STRING)
        private Role role;

        // constructors, getters, setters
    }


