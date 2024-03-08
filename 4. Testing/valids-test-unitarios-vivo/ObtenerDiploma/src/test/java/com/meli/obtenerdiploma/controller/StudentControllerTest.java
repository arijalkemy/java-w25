package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;


    @Test
    void registerStudent() {
        //ARRANGE
        StudentDTO studentDTO = TestData.getStudent("Erling Haaland");

        //ACT
        ResponseEntity<?> response = studentController.registerStudent(studentDTO);

        //ASSERT
        verify(studentService, atLeastOnce()).create(studentDTO);
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    void getStudent() {
        //ARRANGE
        StudentDTO studentDTO = TestData.getStudent("Cristiano Ronaldo");
        when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);

        //ACT
        StudentDTO actualStudent = studentController.getStudent(studentDTO.getId());

        //ASSERT
        assertEquals(studentDTO.getId(),actualStudent.getId());
        assertEquals(studentDTO.getStudentName(),actualStudent.getStudentName());
    }

    @Test
    void modifyStudent() {
        //ARRANGE
        StudentDTO studentDTO = TestData.getStudent("Leo Ronaldo");

        //ACT
        ResponseEntity<?> response = studentController.modifyStudent(studentDTO);

        //ASSERT
        verify(studentService, atLeastOnce()).update(studentDTO);
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    void removeStudent() {
        //ARRANGE
        StudentDTO studentDTO = TestData.getStudent("Cristiano Messi");

        //ACT
        ResponseEntity<?> response = studentController.removeStudent(studentDTO.getId());

        //ASSERT
        verify(studentService, atLeastOnce()).delete(studentDTO.getId());
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    void listStudents() {
        //ARRANGE
        Set<StudentDTO> studentDTOSet = TestData.getStudentSet();
        when(studentService.getAll()).thenReturn(studentDTOSet);

        //ACT
        Set<StudentDTO> actualStudentDTOSet =
                studentController.listStudents();

        //ASSERT
        assertEquals(studentDTOSet.size(),actualStudentDTOSet.size());
        assertTrue(studentDTOSet.containsAll(actualStudentDTOSet));
    }
}