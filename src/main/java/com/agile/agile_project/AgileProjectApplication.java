package com.agile.agile_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity
@SpringBootApplication
public class AgileProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgileProjectApplication.class, args);
	}

}
