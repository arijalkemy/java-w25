package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StudentDAOTest {

    @Autowired
    StudentDAO studentDAO;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void saveOk() {
        //Arrange
        int quantityStudents = studentRepository.findAll().size();
        StudentDTO studentDTO = Util.getStudenDto();
        //Act
        studentDAO.save(studentDTO);

        //Assert
        assertEquals(quantityStudents+1,studentRepository.findAll().size());
        assertEquals(studentDTO,studentDAO.findById(studentDTO.getId()));

    }
    @Test
    void saveDuplicate() {
        //Arrange
        int quantityStudents = studentRepository.findAll().size();
        StudentDTO studentDTO = Util.getStudenDto();
        //Act
        studentDAO.save(studentDTO);

        //Assert
        assertEquals(quantityStudents,studentRepository.findAll().size());

    }

    @Test
    void deleteOK() {
        //Arrange
        long idStudent = 3;
        boolean expected = true;
        boolean result;

        //Act
        result =  studentDAO.delete(idStudent);

        //Assertions
        assertEquals(expected,result);

    }
    @Test
    void deleteStudentNotFoundException() {
        //Arrange
        boolean expected = false;
        boolean result;

        //Act
        result =  studentDAO.delete(0L);

        //Assertions
        assertEquals(expected,result);

    }

    @Test
    void existsOK() {
        //Arrange
        StudentDTO studentDTO = Util.getAllStudenDto().iterator().next();
        boolean expected = true;
        boolean result;

        //Act
        result =  studentDAO.exists(studentDTO);

        //Assertions
        assertEquals(expected,result);
    }
    @Test
    void existsStudentNotFoundException() {
        //Arrange
        StudentDTO studentDTO = Util.getStudenDto();
        boolean expected = false;
        boolean result;

        //Act
        result =  studentDAO.exists(studentDTO);

        //Assertions
        assertEquals(expected,result);
    }

    @Test
    void findByIdOk() {
        //Arrange
        StudentDTO studentDTOExpected = Util.getAllStudenDto().iterator().next();
        StudentDTO studentDTOResult;

        //Act
        studentDTOResult =  studentDAO.findById(studentDTOExpected.getId());

        //Assertions
        assertEquals(studentDTOExpected,studentDTOResult);
    }
    @Test
    void findByIdStudentNotFoundException() {
        //Arrange
        long idStudent = anyLong();

        //Act
        //Assertions
        assertThrows(StudentNotFoundException.class,()->studentDAO.findById(idStudent));
    }
}