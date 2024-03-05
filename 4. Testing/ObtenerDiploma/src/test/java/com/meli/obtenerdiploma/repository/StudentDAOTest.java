package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {

    @Autowired
    StudentDAO studentDAO;

    @BeforeEach
    public void setUp(){
        studentDAO.cleanUp();
        TestUtils.emptyUsersFile();
        studentDAO.save(TestUtils.generateStudent1());
        studentDAO.save(TestUtils.generateStudent2());
    }

    @Test
    void saveOk() {
        //Arrange
        StudentDTO studentDTO = TestUtils.generateStudentDto(4L, "pepe", null, null, null);

        //Act & Assert
        assertDoesNotThrow(()->studentDAO.save(studentDTO));
    }

    @Test
    void deleteOK() {
        //Arrange
        Long studentId = 1L;

        //Act & Assert
        assertDoesNotThrow(()->studentDAO.delete(studentId));
    }

    @Test
    void exists() {
        //Arrange
        StudentDTO student = TestUtils.generateStudentDto(3L, "pepe", null, null, null);

        //Act & Assert
        assertDoesNotThrow(()->studentDAO.exists(student));
    }

    @Test
    void findById() {
        //Arrange
        StudentDTO student = TestUtils.generateStudent1();

        //Act
        StudentDTO studentDTO = studentDAO.findById(1L);

        //Assert
        assertThat(student).usingRecursiveComparison().isEqualTo(studentDTO);
    }
}