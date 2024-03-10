package com.meli.obtenerdiploma.repository.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;

class StudentDAOTest {

    private IStudentRepository studentRepository;
    private IStudentDAO studentDAO;

    @BeforeEach
    void setupData() {
        studentRepository = new StudentRepository();
        studentDAO = new StudentDAO();
    }

    @AfterEach
    void resetData() {
        studentRepository.findAll().forEach(student -> studentDAO.delete(student.getId()));
    }

    @Test
    void testDeleteWhenEntityExist() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        studentDAO.save(studentDTO);
        // act
        boolean studentWasDeleted = studentDAO.delete(studentDTO.getId());
        Exception exceptionResult = null;
        try {
            studentDAO.findById(studentDTO.getId());
        } catch (Exception exception) {
            exceptionResult = exception;
        }
        // assert
        assertTrue(studentWasDeleted);
        assertEquals(StudentNotFoundException.class, exceptionResult.getClass());
    }

    @Test
    void testDeleteWhenEntityNotExist() {
        // arrange
        Long noExistentEntityId = 10L;
        // act
        boolean studentWasDeleted = studentDAO.delete(noExistentEntityId);
        // assert
        assertFalse(studentWasDeleted);
    }

    @Test
    void testExistsWhenEntityExist() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        studentDAO.save(studentDTO);
        // act
        boolean studentExists = studentDAO.exists(studentDTO);

        // assert
        assertTrue(studentExists);
    }

    @Test
    void testExistsWhenEntityNotExist() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                2L,
                "JULIAN",
                "N/A",
                5.0,
                subjects);
        // act
        boolean studentExists = studentDAO.exists(studentDTO);

        // assert
        assertFalse(studentExists);
    }

    @Test
    void testFindByIdWhenEntityExist() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        studentDAO.save(studentDTO);
        // act
        StudentDTO studentDTOResult = null;
        try {
            studentDTOResult = studentDAO.findById(studentDTO.getId());
        } catch (Exception e) {
            fail();
        }
        // assert
        assertEquals(studentDTO, studentDTOResult);
    }

    @Test
    void testFindByIdWhenEntityNotExist() {
        // arrange
        Long noExistentEntityId = 10L;
        // act
        Exception studentDTOExceptionResult = null;
        try {
            studentDAO.findById(noExistentEntityId);
        } catch (Exception exception) {
            studentDTOExceptionResult = exception;
        }
        // assert
        assertEquals(StudentNotFoundException.class, studentDTOExceptionResult.getClass());
    }

    @Test
    void testSave() {
        // arrange
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        // act
        studentDAO.save(studentDTO);
        boolean studentExists = studentDAO.exists(studentDTO);
        // assert
        assertTrue(studentExists);

    }
}
