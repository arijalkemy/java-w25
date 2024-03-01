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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentServiceMock;
    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudentTestOk(){
        //Arrange
        StudentDTO studentParam = ObjectFactory.createStudentDTOWithAverageBelowNine();
        ResponseEntity<?> expectedResult = ResponseEntity.ok(null);

        //Act & Assert
        ResponseEntity<?> actual = studentController.registerStudent(studentParam);

        verify(studentServiceMock, times(1)).create(studentParam);
        assertEquals(expectedResult,actual);
    }

    @Test
    void getStudentTestOk(){
        //Arrange
        Long studentId = anyLong();
        StudentDTO expectedResult = ObjectFactory.createStudentDTOWithAverageAboveNine();

        //Act
        when(studentServiceMock.read(studentId)).thenReturn(expectedResult);
        StudentDTO actual = studentController.getStudent(studentId);

        //Assert
        assertEquals(expectedResult,actual);

    }

    @Test
    void modifyStudentTestOk(){
        //Arrange
        StudentDTO studentParam = ObjectFactory.createStudentDTOWithAverageBelowNine();
        ResponseEntity<?> expectedResult = ResponseEntity.ok(null);

        //Act & Assert
        ResponseEntity<?> actual = studentController.modifyStudent(studentParam);

        verify(studentServiceMock, times(1)).update(studentParam);
        assertEquals(expectedResult,actual);
    }

    @Test
    void removeStudentTestOk(){
        //Arrange
        Long studentId = anyLong();
        ResponseEntity<?> expectedResult = ResponseEntity.ok(null);

        //Act
        ResponseEntity<?> actual = studentController.removeStudent(studentId);

        //Assert
        verify(studentServiceMock, times(1)).delete(studentId);
        assertEquals(expectedResult,actual);
    }

    @Test
    void listStudentsTestOk(){
        //Arrange
        Set<StudentDTO> expectedResult = ObjectFactory.createSetStudentDTO();

        //Act
        when(studentServiceMock.getAll()).thenReturn(expectedResult);
        Set<StudentDTO> actual = studentController.listStudents();

        //Assert
        assertEquals(expectedResult,actual);
    }
}
