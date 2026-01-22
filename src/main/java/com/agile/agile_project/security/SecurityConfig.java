package com.agile.agile_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth

                        // 🔓 SWAGGER
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()

                        // 🔓 AUTH
                        .requestMatchers("/api/auth/**").permitAll()

                        // 👤 USERS (SCRUM MASTER uniquement)
                        .requestMatchers(HttpMethod.GET, "/api/users/**")
                        .hasRole("SCRUM_MASTER")
                        .requestMatchers(HttpMethod.POST, "/api/users/**")
                        .hasRole("SCRUM_MASTER")

                        // 📦 PRODUCT BACKLOG
                        .requestMatchers(HttpMethod.POST, "/api/product-backlogs/**")
                        .hasRole("PO")
                        .requestMatchers(HttpMethod.GET, "/api/product-backlogs/**")
                        .hasAnyRole("PO", "SCRUM_MASTER", "DEV")

                        // 📘 USER STORIES (PO)
                        .requestMatchers(HttpMethod.POST, "/api/user-stories/**")
                        .hasRole("PO")

                        // 🏃 SPRINT (SCRUM MASTER)
                        .requestMatchers("/api/sprints/**")
                        .hasRole("SCRUM_MASTER")

                        // ✅ TASKS (DEV)
                        .requestMatchers(HttpMethod.POST, "/api/tasks/**")
                        .hasRole("DEV")

                        // 🔒 TOUT LE RESTE
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
