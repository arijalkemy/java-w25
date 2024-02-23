package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.MockBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    private StudentDAO studentDAO;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("Guardar estudiante (DAO) - Éxito")
    void saveStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);
        studentDAO.save(paramStudent);

        boolean exists = studentDAO.exists(paramStudent);

        assertTrue(exists);
    }

    @Test
    @DisplayName("Eliminar estudiante (DAO) - Éxito")
    void deleteStudentCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(2L);
        studentDAO.save(paramStudent);

        boolean deleted = studentDAO.delete(paramStudent.getId());

        assertTrue(deleted);
    }

    @Test
    @DisplayName("Eliminar estudiante no existente (DAO) - Fracaso")
    void deleteNonExistingStudent() {
        boolean deleted = studentDAO.delete(100L);

        assertFalse(deleted);
    }

    @Test
    @DisplayName("Buscar estudiante por ID (DAO) - Éxito")
    void findStudentByIdCorrect() {
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);
        studentDAO.save(paramStudent);

        StudentDTO foundStudent = studentDAO.findById(paramStudent.getId());

        assertEquals(paramStudent, foundStudent);
    }

    @Test
    @DisplayName("Buscar estudiante por ID no existente (DAO) - Excepción")
    void findNonExistingStudentById() {
        assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(100L));
    }
}
