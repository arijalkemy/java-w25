package com.example.bootcamp.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "likedCourses") // Para bidireccional, si es unidireccional no hace falta
    Set<Student> likes;
}
