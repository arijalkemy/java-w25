package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    StudentService studentService;
    @InjectMocks StudentController studentController;

    @Test
    void registerStudentOk() {
        //Arrange
        StudentDTO expectedStudent = new StudentDTO(1L, "Carlos", "Melo", 5.5, new ArrayList<>());
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity<>(HttpStatus.OK);

        //Act
        studentController.registerStudent(expectedStudent);
        //Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(studentService,times(1)).create(expectedStudent);
    }

    @Test
    void getStudent() {
        //Arrange
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity<>(HttpStatus.OK);

        //Act
        studentController.getStudent(5L);
        //Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(studentService,times(1)).read(5L);
    }

    @Test
    void modifyStudent() {
        //Arrange
        StudentDTO expectedStudent = new StudentDTO(1L, "Carlos", "Melo", 5.5, new ArrayList<>());
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity<>(HttpStatus.OK);

        //Act
        studentController.modifyStudent(expectedStudent);
        //Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(studentService,times(1)).update(expectedStudent);
    }

    @Test
    void removeStudent() {
        //Arrange
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity<>(HttpStatus.OK);

        //Act
        studentController.removeStudent(5L);
        //Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(studentService,times(1)).delete(5L);
    }

    @Test
    void listStudents() {
        //Arrange
        Set<StudentDTO> studentExpected = new HashSet<>();
        when(studentService.getAll()).thenReturn(studentExpected);
        ResponseEntity<StudentDTO> responseEntity = new ResponseEntity<>(HttpStatus.OK);
        //Act
        Set<StudentDTO> result = studentController.listStudents();
        //Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(studentExpected,result);
        verify(studentService,times(1)).getAll();
    }
}