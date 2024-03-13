package com.example.relations.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Course {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long Id;
    String name;

    @ManyToMany(mappedBy = "studentCourse") //Sin esto hay problemas
    Set<Student> students;
}
