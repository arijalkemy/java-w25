package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentRepositoryTest {
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Buscar todos los estudiantes (Repository) - Éxito")
    void findAllStudentsCorrect() {
        Set<StudentDTO> allStudents = studentRepository.findAll();

        assertThat(allStudents).isNotNull().isNotEmpty();
    }
}
