package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepository extends JpaRepository<Course, Long> {
}
