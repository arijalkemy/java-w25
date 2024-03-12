package me.davidlake.proyectodeportistas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ProyectoDeportistasApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoDeportistasApplication.class, args);
    }
}