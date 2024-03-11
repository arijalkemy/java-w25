package com.example.bootcamp.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany // Indica relacion muchoas a muchaos
    @JoinTable( // Se usa del lado del propietario de la relacion
            name = "course_link",
            joinColumns = @JoinColumn(name = "student_id"), // indica el atributo de union de la clase student. Apunta al ID de la clase propietaria
            inverseJoinColumns = @JoinColumn(name = "course_id") // indica el atributo de union de la clase Course.  Apunta al ID de la clase inversa
    )
    private Set<Course> likedCourses;
}
