package com.bootcamp.ejercicio_qatester.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @ManyToMany(mappedBy = "testers")
    List<TestCase> tests;
    @OneToOne(mappedBy = "tester")
    GithubProfile githubProfile;
}
