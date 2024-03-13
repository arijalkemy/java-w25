package com.example.ejemplo_jpa.model.many_to_many;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToMany(mappedBy = "likedCourses", cascade = CascadeType.REMOVE)
    private Set<Student> likes;
}
