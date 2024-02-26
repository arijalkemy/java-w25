package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.ObjectFactory;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    IStudentDAO studentDAO;

    @BeforeEach
    void setUP(){
        studentDAO = new StudentDAO();
    }


    @Test
    void saveTestOk(){
        //Arrange
        StudentDTO student = ObjectFactory.createStudentDTOWithAverageAboveNine();

        //Act
        studentDAO.save(student);
        boolean exist = studentDAO.exists(student);
        //Assert
        assertTrue(exist);
    }

    @Test
    void deleteTestOk(){
        //Arrange
        StudentDTO student = ObjectFactory.createStudentDTOWithAverageBelowNine();
        studentDAO.save(student);

        //Act
        studentDAO.delete(student.getId());

        //Assert
        assertFalse(studentDAO.exists(student));
    }
    @Test
    void existsTestOk(){
        //Arrange
        StudentDTO student = ObjectFactory.createStudentDTOWithAverageBelowNine();
        studentDAO.save(student);
        boolean expected = true;

        //Act
        boolean actual = studentDAO.exists(student);

        //Assert
        assertEquals(expected, actual);
    }
    @Test
    void findByIdTestOk(){
        //Arrange
        StudentDTO studentExpected = ObjectFactory.createStudentDTOWithAverageBelowNine();
        studentDAO.save(studentExpected);

        //Act
        StudentDTO actual = studentDAO.findById(studentExpected.getId());

        //Assert
        assertEquals(studentExpected, actual);
    }

}
