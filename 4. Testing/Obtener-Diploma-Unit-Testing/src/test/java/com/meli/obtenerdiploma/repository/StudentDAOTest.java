package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.ObjectFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private final IStudentDAO studentDAO = new StudentDAO();

    @Test
    public void saveTestOk() {
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageBelowNine();

        //Act
        studentDAO.save(studentDTO);

        //Assert
        assertEquals(studentDAO.findById(studentDTO.getId()), studentDTO);
    }

    @Test
    public void deleteTestOk() {
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageBelowNine();

        //Act
        studentDAO.save(studentDTO);
        boolean result = studentDAO.delete(studentDTO.getId());

        //Assert
        assertTrue(result);
    }

    @Test
    public void deleteTestNotExistingStudent() {
        //Arrange
        Long notExistingId = Long.MAX_VALUE;

        //Act
        boolean result = studentDAO.delete(notExistingId);

        //Assert
        assertFalse(result);
    }

    @Test
    public void existsTestOk(){
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageBelowNine();

        //Act
        studentDAO.save(studentDTO);
        boolean result = studentDAO.exists(studentDTO);

        //Assert
        assertTrue(result);
    }

    @Test
    public void existsTestNotExistingStudent() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO();

        //Act
        boolean result = studentDAO.exists(studentDTO);

        //Assert
        assertFalse(result);
    }

    @Test
    public void findByIdTestOk() {
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageBelowNine();

        //Act
        studentDAO.save(studentDTO);
        StudentDTO result = studentDAO.findById(studentDTO.getId());

        //Assert
        assertEquals(studentDTO, result);
    }

    @Test
    public void findByIdTestThrowsStudentNotFoundException() {
        //Arrange
        Long notExistingId = Long.MAX_VALUE;

        //Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(notExistingId));
    }

}
