package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StudentRepositoryTest {
    IStudentRepository studentRepository;
    @BeforeEach
    void setUp() {
        this.studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("Buscar todos los estudiantes - Éxito")
    void findAllTestOK(){
        //Arrange & Act
        Set<StudentDTO> students = studentRepository.findAll();

        //Assert
        assertThat(students).isNotNull().isNotEmpty();
    }
}
