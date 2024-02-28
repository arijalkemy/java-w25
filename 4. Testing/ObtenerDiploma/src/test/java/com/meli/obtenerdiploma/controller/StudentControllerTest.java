package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.Validation;
import javax.validation.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    StudentService studentService;
    @InjectMocks
    StudentController studentController;

    private Validator validator;
    @BeforeEach
    public void setUp(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void registerStudentOK() {
        //Arrange
        StudentDTO studentDTO = Util.getStudenDto();
        ResponseEntity<?> responseEntityExpected = ResponseEntity.ok(null);
        ResponseEntity<?> responseEntityResult;

        doNothing().when(studentService).create(any(StudentDTO.class));
        //Act
        responseEntityResult = studentController.registerStudent(studentDTO);

        //Assert
        verify(studentService,atLeast(1)).create(any(StudentDTO.class));
        assertEquals(responseEntityExpected,responseEntityResult);

    }
    @Test
    void registerStudentMethodArgumentNotValidException() {
        //Arrange
        String errorExpected = "El nombre del estudiante no puede estar vacío.";
        StudentDTO studentDTO = Util.getStudenDto();
        studentDTO.setStudentName("");

        //Act
        var violations = validator.validate(studentDTO);

        //Assert
        assertEquals(2,violations.size());
        assertEquals(errorExpected,violations.iterator().next().getMessage());

    }
    @Test
    void getStudentOk() {
        //Arrange
        StudentDTO studentDTOExpected = Util.getStudenDto();
        StudentDTO studentDTOResult;

        when(studentService.read(anyLong())).thenReturn(studentDTOExpected);

        //Act
        studentDTOResult = studentController.getStudent(anyLong());

        //Assert
        assertEquals(studentDTOExpected,studentDTOResult);
    }

    @Test
    void modifyStudentTestOK() {
        //Arrange
        StudentDTO studentDTO = new StudentDTO();//Util.getStudenDto();
        ResponseEntity<?> responseEntityExpected = ResponseEntity.ok(null);
        ResponseEntity<?> responseEntityResult;

        doNothing().when(studentService).update(any(StudentDTO.class));
        //Act
        responseEntityResult = studentController.modifyStudent(studentDTO);

        //Assert
        verify(studentService,atLeast(1)).update(any(StudentDTO.class));
        assertEquals(responseEntityExpected,responseEntityResult);
    }

    @Test
    void removeStudentTest() {
        //Arrange
        ResponseEntity<?> responseEntityExpected = ResponseEntity.ok(null);
        ResponseEntity<?> responseEntityResult;

        doNothing().when(studentService).delete(anyLong());
        //Act
        responseEntityResult = studentController.removeStudent(anyLong());

        //Assert
        verify(studentService,atLeast(1)).delete(anyLong());
        assertEquals(responseEntityExpected,responseEntityResult);
    }

    @Test
    void listStudentsTest() {
        //Arrange
        Set<StudentDTO> studentDTOSetExpected = new HashSet<>(List.of(Util.getStudenDto()));
        Set<StudentDTO> studentDTOSetResult;

        when(studentService.getAll()).thenReturn(studentDTOSetExpected);

        //Act
        studentDTOSetResult = studentController.listStudents();

        //Assert
        assertEquals(studentDTOSetExpected,studentDTOSetResult);
    }
}