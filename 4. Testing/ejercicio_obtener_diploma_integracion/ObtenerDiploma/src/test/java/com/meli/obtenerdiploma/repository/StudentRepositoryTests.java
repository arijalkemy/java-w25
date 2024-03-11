package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Set;

public class StudentRepositoryTests {
    IStudentRepository studentRepository;
    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();

        this.studentDAO = new StudentDAO();
        this.studentRepository = new StudentRepository();
    }

    @Test
    void findAllExistentStudents() {
        // Arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach(s -> studentDAO.save(s));

        // Act
        Set<StudentDTO> studentsResult=studentRepository.findAll();

        // Assert
        Assertions.assertTrue(CollectionUtils.isEqualCollection(students, studentsResult));
    }
}
