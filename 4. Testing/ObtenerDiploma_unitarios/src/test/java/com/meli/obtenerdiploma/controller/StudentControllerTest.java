package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    StudentService studentService;
    @InjectMocks
    StudentController studentController;

    private StudentDTO studentDTO;
    private Set<StudentDTO> studentDTOList;

    @BeforeEach
    void setUp() {

        studentDTO = new StudentDTO();
        studentDTO.setStudentName("Juan");
        studentDTO.setId(1L);
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 6.0);
        studentDTO.setSubjects(List.of(subject1, subject2, subject3));


        studentDTOList = Set.of(studentDTO);
    }

    @Test
    void registerStudent() {
        doNothing().when(studentService).create(studentDTO);
        ResponseEntity<?> result = studentController.registerStudent(studentDTO);
        assertEquals(ResponseEntity.ok(null), result);
    }


    @Test
    void registerStudentNull() {
        doNothing().when(studentService).create(null);
        ResponseEntity<?> result = studentController.registerStudent(null);
        assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    void registerStudentEmpty() {
        StudentDTO studentDTO = new StudentDTO();
        doNothing().when(studentService).create(studentDTO);
        ResponseEntity<?> result = studentController.registerStudent(studentDTO);
        assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    void getStudent() {
        when(studentService.read(1L)).thenReturn(studentDTO);
        StudentDTO result = studentController.getStudent(1L);
        assertEquals(studentDTO, result);

    }

    @Test
    void modifyStudent() {
        doNothing().when(studentService).update(studentDTO);
        ResponseEntity<?> result = studentController.modifyStudent(studentDTO);
        assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    void modfiyStudentNull() {
        doNothing().when(studentService).update(null);
        ResponseEntity<?> result = studentController.modifyStudent(null);
        assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    void removeStudent() {
        doNothing().when(studentService).delete(1L);
        ResponseEntity<?> result = studentController.removeStudent(1L);
        assertEquals(ResponseEntity.ok(null), result);
    }

    @Test
    void listStudents() {
        when(studentService.getAll()).thenReturn(studentDTOList);
        Set<StudentDTO> result = studentController.listStudents();
        assertEquals(studentDTOList, result);
    }

    @Test
    void listStudentsEmpty() {
        when(studentService.getAll()).thenReturn(Set.of());
        Set<StudentDTO> result = studentController.listStudents();
        assertEquals(Set.of(), result);
    }
}