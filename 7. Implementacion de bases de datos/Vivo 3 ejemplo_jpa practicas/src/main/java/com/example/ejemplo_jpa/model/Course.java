package com.example.ejemplo_jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    Set<Student> student;
}
