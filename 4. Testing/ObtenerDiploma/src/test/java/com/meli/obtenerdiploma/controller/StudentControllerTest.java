package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    StudentService service;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudent() {
        //Arrange
        StudentDTO studentDTO = TestUtils.generateStudentDto(1L, "pepe", null, null, null);
        //Act
        studentController.registerStudent(studentDTO);
        //Assert
        verify(service, atLeastOnce()).create(studentDTO);
    }

    @Test
    void getStudent() {
        //Arrange
        Long studentId = 1L;
        StudentDTO expectedStudentDTO = TestUtils.generateStudentDto(1L, "pepe", null, null, null);
        when(service.read(studentId)).thenReturn(expectedStudentDTO);
        //Act
        StudentDTO studentDTO = studentController.getStudent(studentId);
        //Assert
        assertThat(expectedStudentDTO).usingRecursiveComparison().isEqualTo(studentDTO);
    }

    @Test
    void modifyStudent() {
        //Arrange
        StudentDTO studentDTO = TestUtils.generateStudentDto(1L, "pepe", null, null, null);
        //Act
        studentController.modifyStudent(studentDTO);
        //Assert
        verify(service, atLeastOnce()).update(studentDTO);
    }

    @Test
    void removeStudent() {
        //Arrange
        Long studentId = 1L;
        //Act
        studentController.removeStudent(studentId);
        //Assert
        verify(service, atLeastOnce()).delete(studentId);
    }

    @Test
    void listStudents() {
        //Arrange
        Set<StudentDTO> expectedStudentsDTO = TestUtils.getAllStudents();
        when(service.getAll()).thenReturn(expectedStudentsDTO);
        //Act
        Set<StudentDTO> studentsDTO = studentController.listStudents();
        //Assert
        assertThat(expectedStudentsDTO).usingRecursiveComparison().isEqualTo(studentsDTO);
    }
}