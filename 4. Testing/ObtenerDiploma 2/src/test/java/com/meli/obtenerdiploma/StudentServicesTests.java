package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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

import static org.mockito.Mockito.*;

@SpringBootTest // Para que spring entienda que hay una inyeccion de dependencias entre clases
@ExtendWith(MockitoExtension.class)
public class StudentServicesTests {

    @Mock
    StudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService service;
    FactoryStudent f = new FactoryStudent();
    @Test
    public void createTestOK(){
        // Arrange
        StudentDTO studentParam = new StudentDTO();
        // Act y Assert
        service.create(studentParam);
        verify(studentDAO).save(studentParam);
    }

    @Test
    public void deleteTestOK(){
        // Arrange
        Long studentIdParam = 1L;
        // Act y Assert
        service.delete(studentIdParam);
        verify(studentDAO).delete(studentIdParam);
    }

    @Test
    public void getAllTestOK(){
        // Arrange
        Set<StudentDTO> studentsExpected = f.getAllStudents();
        // Act
        when(studentRepository.findAll()).thenReturn(studentsExpected);
        // Assert
        Assertions.assertEquals(studentsExpected, service.getAll());
    }

    @Test
    public void readTestOK(){
        // Arrange
        Long studentIdParam = 1L;
        StudentDTO juan = f.getJuanStudent();
        // Act
        when(studentDAO.findById(studentIdParam)).thenReturn(juan);
        // Assert
        Assertions.assertEquals(juan, service.read(studentIdParam));
    }

    @Test
    public void updateTestOK(){
        // Arrange
        StudentDTO studentParam = f.getJuanStudent();
        // Act y Assert
        service.update(studentParam);
        verify(studentDAO, atLeast(1)).save(studentParam);
    }

}
