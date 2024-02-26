package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
@SpringBootTest

class StudentDAOTest {
    @Autowired
    private StudentDAO studentDAO;
    private Validator validator;
    @BeforeEach
    public void setUp() {
        // Create a new validator instance
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void saveValidStudentTestOk() {
        //Arrange
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Pepito");
        expectedStudent.setId(100L);
        expectedStudent.setStudentName("");
        expectedStudent.setSubjects(Collections.singletonList(new SubjectDTO("Math", 8.5)));


        //Act
        studentDAO.save(expectedStudent);
        StudentDTO result = studentDAO.findById(expectedStudent.getId());
        //Assert
        assertNotNull(result);
        assertEquals(expectedStudent.getId(),result.getId());
        assertEquals(expectedStudent,result);
    }

    @Test
    void saveInValidStudentTest() {
        //Arrange
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("pepito");
        expectedStudent.setId(100L);
        expectedStudent.setStudentName("");

        //Act
        studentDAO.save(expectedStudent);
        StudentDTO result = studentDAO.findById(expectedStudent.getId());
        //Assert
        assertThrows(ConstraintViolationException.class, () -> {
            validator.validate(expectedStudent);
        });

    }

    @Test
    void deleteTestOk() {
        //Arrange
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("John Doe");
        student.setSubjects(Collections.singletonList(new SubjectDTO("Math", 8.5)));
        studentDAO.save(student);

        //Act
        boolean deleted = studentDAO.delete(11L);

        // Assert
        assertTrue(deleted);
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.delete(100L);
        });
    }

    @Test
    void exists() {
    }

    @Test
    void findById() {
    }

    @Test
    void testSave() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testExists() {
    }

    @Test
    void testFindById() {
    }
}