package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;
    @InjectMocks
    StudentController studentController;

    @Test
    void getStudentTestOk(){
        //Arrange
        Long studentID = 0L;
        StudentDTO expectedStudent = ObjectFactory.createStudentDTOWithAverageAboveNine();
        when(studentService.read(studentID)).thenReturn(expectedStudent);

        //Act
        StudentDTO actualStudent = studentController.getStudent(studentID);

        //Assert
        assertEquals(expectedStudent, actualStudent);
    }
    @Test
    void removeStudentTestOk(){
        //Arrange
        Long studentID = 0L;

        //Act
        studentController.removeStudent(studentID);

        //Assert
        verify(studentService, times(1)).delete(studentID);
    }
    @Test
    void listStudentsTestOk(){
        //Arrange
        Set<StudentDTO> expectedStudents = ObjectFactory.createSetStudentDTO();
        when(studentService.getAll()).thenReturn(expectedStudents);
        //Act
        Set<StudentDTO> actualStudents = studentController.listStudents();

        //Assert
        assertEquals(expectedStudents, actualStudents);
    }
    @Test
    void registerStudentTestOk(){
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageAboveNine();

        //Act
        studentController.registerStudent(studentDTO);

        //Assert
        verify(studentService, times(1)).create(studentDTO);
    }
    @Test
    void modifyStudentsTestOk(){
        //Arrange
        StudentDTO studentDTO = ObjectFactory.createStudentDTOWithAverageAboveNine();

        //Act
        studentController.modifyStudent(studentDTO);

        //Assert
        verify(studentService, times(1)).update(studentDTO);
    }

}
