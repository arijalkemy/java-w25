package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.many_to_many.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInterface extends JpaRepository<Student, Long> {
}
