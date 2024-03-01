package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    public void createTestOk(){
        //Arrange
        StudentDTO studentGenerated = ObjectFactory.createStudentDTOWithAverageBelowNine();

        //Act
        studentService.create(studentGenerated);

        //Assert
        verify(studentDAO, times(1)).save(studentGenerated);
    }

    @Test void readTestOk(){
        //Arrange
        long id = 1L;
        StudentDTO studentGenerated = ObjectFactory.createStudentDTOWithAverageBelowNine();
        when(studentDAO.findById(id)).thenReturn(studentGenerated);

        //Act
        StudentDTO studentDto = studentDAO.findById(id);

        //Assert
        assertEquals(studentGenerated, studentDto);
    }


    @Test
    public void updateTestOk(){
        //Arrange
        StudentDTO studentGenerated = ObjectFactory.createStudentDTOWithAverageBelowNine();

        //Act
        studentService.update(studentGenerated);

        //Assert
        verify(studentDAO, times(1)).save(studentGenerated);
    }

    @Test
    public void deleteTestOk(){
        //Arrange
        StudentDTO studentGenerated = ObjectFactory.createStudentDTOWithAverageBelowNine();

        //Act
        studentService.delete(studentGenerated.getId());

        //Assert
        verify(studentDAO, times(1)).delete(studentGenerated.getId());
    }

    @Test
    public void getAllTestOk() {
        //Arrange
        Set<StudentDTO> expectedStudentDTOSet = ObjectFactory.createSetStudentDTO();
        when(studentRepository.findAll()).thenReturn(expectedStudentDTOSet);

        //Act
        Set<StudentDTO> result = studentService.getAll();

        //Assert
        assertEquals(expectedStudentDTOSet, result);
    }

    @Test
    public void readTestThrowsStudentNotFoundExceptionWhenIdIsWrong() {
        //Arrange
        Long studentId = 1L;
        doThrow(StudentNotFoundException.class).when(studentDAO).findById(studentId);

        //Act and assert
        assertThrows(StudentNotFoundException.class, () -> studentService.read(studentId));
    }
}
