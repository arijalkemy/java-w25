package com.dto.deportistas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DeportistasApplication {
	// Declara una instancia de Logger
	private static final Logger logger = Logger.getLogger(DeportistasApplication.class.getName());

	public static void main(String[] args) {
		logger.info("http://localhost:8080/");
		SpringApplication.run(DeportistasApplication.class, args);
	}
}
