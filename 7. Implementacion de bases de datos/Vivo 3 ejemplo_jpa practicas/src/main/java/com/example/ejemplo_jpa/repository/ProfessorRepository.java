package com.example.ejemplo_jpa.repository;

import com.example.ejemplo_jpa.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
