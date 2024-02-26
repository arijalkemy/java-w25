package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import utils.FactoryStudent;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    FactoryStudent f = new FactoryStudent();

    @Autowired
    StudentDAO studentDAO;

    @Test
    void saveTestOk(){
        //Arrange
        StudentDTO sent = f.getNewStudent();
        //Act
        studentDAO.save(sent);
        //Assert
        assertTrue(studentDAO.exists(sent));
        assertEquals(3L, sent.getId());
        assertEquals(studentDAO.findById(sent.getId()), sent);
    }

    @Test
    void deleteTestOk(){
        //Arrange
        Long stuId = 3L;
        Boolean expected = true;
        //Act
        Boolean result = studentDAO.delete(stuId);
        //Assert
        assertEquals(expected,result);
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(stuId));
    }

    @Test
    void existsTestOk(){
        //Arrange
        StudentDTO student = f.getStudent();
        Boolean expected = true;
        //Act
        Boolean result = studentDAO.exists(student);
        //Assert
        assertEquals(expected,result);
    }

    @Test
    void findByIdTestOK() {
        //Arrange
        Long stuId = 2L;
        StudentDTO expected = f.getStudent();
        //Act
        StudentDTO result = studentDAO.findById(stuId);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    void findByIdTestStudentNotFoundException() {
        //Arrange
        Long stuId = 3L;
        //Act
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(stuId));
        //Assert
    }
}
