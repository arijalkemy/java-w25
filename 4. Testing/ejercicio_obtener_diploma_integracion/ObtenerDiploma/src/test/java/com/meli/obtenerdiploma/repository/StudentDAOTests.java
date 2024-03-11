package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;


public class StudentDAOTests {
    // Unit test without Mocks

    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    void createNonExistentStudent() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act
        studentDAO.save(student);

        // Assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    void createExistentStudent() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act
        studentDAO.save(student);

        // Assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    void modifyNonExistentStudent() {
        // Arrange
        StudentDTO student1 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        StudentDTO student2 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        student2.setId(999L);
        student2.setStudentName("Marco Polo");

        studentDAO.save(student1);

        // Act
        studentDAO.save(student2);

        // Assert
        Assertions.assertTrue(studentDAO.exists(student1));
        Assertions.assertEquals(1L, student1.getId());
        Assertions.assertEquals(studentDAO.findById(student1.getId()), student1);

        Assertions.assertTrue(studentDAO.exists(student2));
        Assertions.assertEquals(2L, student2.getId());
        Assertions.assertEquals(studentDAO.findById(student2.getId()), student2);
    }

    @Test
    void modifyExistentStudent() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // Act
        student.setStudentName("Marco Polo");
        studentDAO.save(student);

        // Assert
        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    void findExistentStudent() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // Act
        StudentDTO studentResult = studentDAO.findById(student.getId());

        // Assert
        Assertions.assertEquals(student, studentResult);
    }

    @Test
    void findNonExistentStudent() {
        // Arrange
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(student.getId()));
    }

    @Test
    void deleteExistentStudent() {
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(student);

        // Act
        studentDAO.delete(student.getId());

        // Assert
        Assertions.assertFalse(studentDAO.exists(student));
    }

    @Test
    void deleteNonExistentStudent() {
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act & Assert
        Assertions.assertFalse(studentDAO.exists(student));
        Assertions.assertThrows(StudentNotFoundException.class, ()->studentDAO.findById(student.getId()));
    }
}
