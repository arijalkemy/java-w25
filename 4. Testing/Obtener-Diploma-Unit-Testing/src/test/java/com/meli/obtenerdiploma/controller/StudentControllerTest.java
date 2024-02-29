package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void registerStudentTestOk() {
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageBelowNine();
        ResponseEntity<?> expectedResult = ResponseEntity.ok(null);

        //Act
        ResponseEntity<?> result = studentController.registerStudent(studentDTO);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void getStudentTestOk() {
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageBelowNine();
        when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);

        //Act
        StudentDTO result = studentController.getStudent(studentDTO.getId());

        //Assert
        assertEquals(studentDTO, result);
    }

    @Test
    public void modifyStudentTestOk() {
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageBelowNine();
        ResponseEntity<?> expectedResult = ResponseEntity.ok(null);

        //Act
        ResponseEntity<?> result = studentController.modifyStudent(studentDTO);

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void removeStudentTestOk() {
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageBelowNine();
        ResponseEntity<?> expectedResult = ResponseEntity.ok(null);

        //Act
        ResponseEntity<?> result = studentController.removeStudent(studentDTO.getId());

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void listStudentsTestOk() {
        //Arrange
        Set<StudentDTO> studentDTOSet = ObjectFactory.createSetStudentDTO();
        when(studentService.getAll()).thenReturn(studentDTOSet);

        //Act
        Set<StudentDTO> result = studentController.listStudents();

        //Assert
        assertEquals(studentDTOSet, result);
    }

}
