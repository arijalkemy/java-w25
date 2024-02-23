package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import com.meli.obtenerdiploma.unitTest.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    void createTest(){
        //Arrange
        StudentDTO student = new StudentDTO();

        //Act
        studentService.create(student);

        //Assert
        verify(studentDAO, times(1)).save(student);
    }
    @Test
    void readTest(){
        //Arrange
        Long id = 0L;
        StudentDTO expectedStudent = ObjectFactory.createStudentDTOWithAverageAboveNine();
        when(studentDAO.findById(id)).thenReturn(expectedStudent);

        //Act
        StudentDTO actualStudent = studentService.read(id);

        //Assert
        assertEquals(expectedStudent, actualStudent);
    }
    @Test
    void updateTest(){
        //Arrange
        StudentDTO student = new StudentDTO();

        //Act
        studentService.update(student);

        //Assert
        verify(studentDAO, times(1)).save(student);
    }
    @Test
    void deleteTest(){
        //Arrange
        Long id = 0L;
        //Act
        studentService.delete(id);

        //Assert
        verify(studentDAO, times(1)).delete(id);
    }
    @Test
    void getAllTest(){
        //Arrange
        Set<StudentDTO> expectedStudents = ObjectFactory.createSetStudentDTO();
        when(studentRepository.findAll()).thenReturn(expectedStudents);

        //Act
        Set<StudentDTO> actualStudents = studentService.getAll();

        //Assert
        assertEquals(expectedStudents, actualStudents);
    }
}
