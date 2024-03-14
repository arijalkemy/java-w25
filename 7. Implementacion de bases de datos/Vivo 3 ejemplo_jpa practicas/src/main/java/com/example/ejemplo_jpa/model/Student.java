package com.example.ejemplo_jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
@SequenceGenerator(name="PRIVATE_SEQ", sequenceName="private_sequence")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE, generator="PRIVATE_SEQ")
    private Long id;
    private String dni;
    private String name;
    private String lastname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id", nullable = false)
    private Professor professor;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<SchoolSupply> supplies;

    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
}
