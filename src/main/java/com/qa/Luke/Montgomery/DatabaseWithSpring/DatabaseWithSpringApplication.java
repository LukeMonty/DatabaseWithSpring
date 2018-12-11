package com.qa.Luke.Montgomery.DatabaseWithSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DatabaseWithSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseWithSpringApplication.class, args);
	}
}
