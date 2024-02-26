package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import utils.FactoryStudent;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServicesApplicationTest {

    FactoryStudent f = new FactoryStudent();

    @Mock
    private StudentDAO studentDAO;
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void crearTestOk(){
        //Arrange
        StudentDTO body = f.getStudent();
        //Act
        studentService.create(body);
        //Assert
        verify(studentDAO, atLeast(1)).save(body);
    }

    @Test
    void readTestOk(){
        //Arrange
        Long longId = 2L;
        StudentDTO expected = f.getStudent();
        when(studentDAO.findById(longId)).thenReturn(expected);
        //Act
        StudentDTO result = studentService.read(longId);
        //Assert
        verify(studentDAO, atLeast(1)).findById(longId);
        assertEquals(expected, result);
    }

    @Test
    void updateTestOk(){
        //Arrange
        StudentDTO body = f.getStudent();
        body.setStudentName("Andrés");
        //Act
        studentService.update(body);
        //Assert
        verify(studentDAO, atLeast(1)).save(body);
    }

    @Test
    void deleteTestOk(){
        //Arrange
        Long studentId = 1L;
        //Act
        studentService.delete(studentId);
        //Assert
        verify(studentDAO, atLeast(1)).delete(studentId);
    }

    @Test
    void getAllTestOk(){
        //Arrange
        Set<StudentDTO> expected = f.getAllStudents();
        when(studentRepository.findAll()).thenReturn(expected);
        //Act
        Set<StudentDTO> result =  studentService.getAll();
        //Assert
        verify(studentRepository, atLeast(1)).findAll();
        assertEquals(expected, result);
    }
}
