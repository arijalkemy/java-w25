package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.many_to_many.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseInterface extends JpaRepository<Course, Long> {
}
