package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    StudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudent() {
        StudentDTO testStudent = new StudentDTO();

        ResponseEntity<?> result = studentController.registerStudent(testStudent);

        verify(studentService).create(testStudent);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void getStudent() {
        StudentDTO testStudent = new StudentDTO(1L, "Test", "Test", 0.0, null);
        Mockito.when(studentService.read(testStudent.getId())).thenReturn(testStudent);

        StudentDTO actualStudent = studentController.getStudent(testStudent.getId());

        Assertions.assertEquals(actualStudent, testStudent);
    }

    @Test
    void modifyStudent() {
        StudentDTO testStudent = new StudentDTO();

        ResponseEntity<?> result = studentController.modifyStudent(testStudent);

        verify(studentService).update(testStudent);
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void removeStudent() {
        StudentDTO testStudent = new StudentDTO();
        testStudent.setId(1L);

        ResponseEntity<?> result = studentController.removeStudent(testStudent.getId());

        verify(studentService).delete(testStudent.getId());
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    void listStudents() {
        Set<StudentDTO> expectedStudents = new HashSet<>(List.of(
                new StudentDTO(1L, "Testeado 1", "Felicitaciones", 9.5, List.of(
                        new SubjectDTO("Mates", 10.0),
                        new SubjectDTO("Ciencias", 9.0)
                )),
                new StudentDTO(2L, "Testeado 2", "Esfuerzate más", 8.5, List.of(
                        new SubjectDTO("Mates", 8.0),
                        new SubjectDTO("Ciencias", 9.0)
                ))
        ));
        Mockito.when(studentService.getAll()).thenReturn(expectedStudents);

        Set<StudentDTO> result = studentController.listStudents();

        Assertions.assertEquals(expectedStudents, result);
    }
}