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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    StudentService studentService;
    @InjectMocks StudentController studentController;

    @Test
    void registerStudentOK() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        //ACT & ASSERT
        studentController.registerStudent(studentDTO);

        verify(studentService, atLeast(1)).create(studentDTO);
    }
    @Test
    void registerStudentStatusOk() {
        //ARRANGE
        StudentDTO studentDTO = new StudentDTO();
        HttpStatus expectedStatus = HttpStatus.OK;
        //ACT
        HttpStatus resultStatus = studentController.registerStudent(studentDTO).getStatusCode();

        //ASSERT
        assertEquals( expectedStatus, resultStatus);
    }


    @Test
    void getStudentOk() {
        //ARRANGE
        Long studentId = 1L;
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setStudentName("Juan");
        expectedStudent.setId(studentId);

        when(studentService.read(studentId)).thenReturn(expectedStudent);
        //ACT
        StudentDTO resultStudent = studentController.getStudent(studentId);
        //ASSERT

        assertEquals(expectedStudent, resultStudent);
    }

    @Test
    void modifyStudent() {
        //ARRANGE
        //ACT
        //ASSERT
    }

    @Test
    void removeStudent() {
        //ARRANGE
        //ACT
        //ASSERT
    }

    @Test
    void listStudents() {
        //ARRANGE
        //ACT
        //ASSERT
    }
}