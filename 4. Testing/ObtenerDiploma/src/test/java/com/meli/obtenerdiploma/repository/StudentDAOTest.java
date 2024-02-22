package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class StudentDAOTest {
    StudentDAO studentDAO = new StudentDAO();
    @Test
    void saveAndExists() {
        StudentDTO testStudent = new StudentDTO(6L, "Testeado 1", "Felicitaciones", 9.5, List.of(
                new SubjectDTO("Mates", 10.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        studentDAO.save(testStudent);

        assertTrue(studentDAO.exists(testStudent));
    }

    @Test
    void deleteExisting() {
        StudentDTO testStudent = new StudentDTO(6L, "Testeado 1", "Felicitaciones", 9.5, List.of(
                new SubjectDTO("Mates", 10.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        studentDAO.save(testStudent);

        assertTrue(studentDAO.delete(testStudent.getId()));
    }

    @Test
    void deleteNotExisting() {
        StudentDTO testStudent = new StudentDTO(6L, "Testeado 1", "Felicitaciones", 9.5, List.of(
                new SubjectDTO("Mates", 10.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        studentDAO.delete(testStudent.getId());

        assertFalse(studentDAO.delete(testStudent.getId()));
    }

    @Test
    void notExists() {
        StudentDTO testStudent = new StudentDTO(6L, "Testeado 1", "Felicitaciones", 9.5, List.of(
                new SubjectDTO("Mates", 10.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        studentDAO.delete(testStudent.getId());

        assertFalse(studentDAO.exists(testStudent));
    }

    @Test
    void findByIdExisting() {
        StudentDTO testStudent = new StudentDTO(6L, "Testeado 1", "Felicitaciones", 9.5, List.of(
                new SubjectDTO("Mates", 10.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        studentDAO.save(testStudent);
        StudentDTO actualStudent = studentDAO.findById(testStudent.getId());

        assertEquals(testStudent, actualStudent);
    }

    @Test
    void findByIdNotExisting() {
        StudentDTO testStudent = new StudentDTO(6L, "Testeado 1", "Felicitaciones", 9.5, List.of(
                new SubjectDTO("Mates", 10.0),
                new SubjectDTO("Ciencias", 9.0)
        ));

        studentDAO.delete(testStudent.getId());

        assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(testStudent.getId()));
    }
}