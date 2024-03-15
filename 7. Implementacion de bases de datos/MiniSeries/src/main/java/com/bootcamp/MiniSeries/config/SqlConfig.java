package com.bootcamp.MiniSeries.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("sql")
@Configuration
public class SqlConfig {

    @PostConstruct
    public void initialize() {
        System.out.println("---- SQL Configuration ----");
    }
}
