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

    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    public void setUp() {
       TestUtilsGenerator.emptyUsersFile();
       this.studentDAO = new StudentDAO();
    }

    @Test
    public void createNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getExampleStudent();

        // act
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void modifyStudent() {
        // arrange
        TestUtilsGenerator.loadUserFile();
        StudentDTO stu = TestUtilsGenerator.getExampleStudent();
        stu.setStudentName("Mercedes");
        // act
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }



    @Test
    public void findExistentStudent() {
        // arrange
        TestUtilsGenerator.loadUserFile();
        StudentDTO stu = TestUtilsGenerator.getExampleStudent();

        // act
        StudentDTO found = studentDAO.findById(stu.getId());

        // assert
        Assertions.assertEquals(found, stu);
    }

    @Test
    public void findNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getExampleStudent();

        // act & assert
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteExistentStudent() {
        // arrange
        TestUtilsGenerator.loadUserFile();
        StudentDTO stu = TestUtilsGenerator.getExampleStudent();

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));

    }


}
