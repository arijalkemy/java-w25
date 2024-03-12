package com.implementacionbd.ejercicio.model.ManyToMany;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany
    @JoinTable(name = "course_like", joinColumns  = @JoinColumn(name = "student_id"), inverseJoinColumns  = @JoinColumn(name = "course_id")) // TABLA
                                                                                                                                           // INTERMEDIA
    private Set<Course> likedCourses;
}
