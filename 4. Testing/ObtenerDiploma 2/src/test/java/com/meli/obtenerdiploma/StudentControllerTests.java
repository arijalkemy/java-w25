package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import utils.FactoryStudent;

import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {
    @Mock
    StudentService studentService;
    @InjectMocks
    StudentController studentController;

    FactoryStudent f = new FactoryStudent();

    @Test
    public void registerStudentTestOK(){
        // Arrange
        StudentDTO studentParam = new StudentDTO();
        // Act y Assert
        studentController.registerStudent(studentParam);
        verify(studentService).create(studentParam);
    }

    @Test
    public void deleteTestOK(){
        // Arrange
        Long studentIdParam = 1L;
        // Act y Assert
        studentController.removeStudent(studentIdParam);
        verify(studentService).delete(studentIdParam);
    }

    @Test
    public void getAllTestOK(){
        // Arrange
        Set<StudentDTO> studentsExpected = f.getAllStudents();
        // Act
        when(studentService.getAll()).thenReturn(studentsExpected);
        // Assert
        Assertions.assertEquals(studentsExpected, studentController.listStudents());
    }

    @Test
    public void getStudentTestOK(){
        // Arrange
        Long studentIdParam = 1L;
        StudentDTO juan = f.getJuanStudent();
        // Act
        when(studentService.read(studentIdParam)).thenReturn(juan);
        // Assert
        Assertions.assertEquals(juan, studentController.getStudent(studentIdParam));
    }

    @Test
    public void updateTestOK(){
        // Arrange
        StudentDTO studentParam = new StudentDTO();
        // Act y Assert
        studentController.registerStudent(studentParam);
        verify(studentService).create(studentParam);
    }
}
