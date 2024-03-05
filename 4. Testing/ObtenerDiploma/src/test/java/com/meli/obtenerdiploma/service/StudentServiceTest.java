package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    void create() {
        //Arrange
        StudentDTO studentDTO = TestUtils.generateStudentDto(1L, "pepe", null, null, null);
        //Act
        service.create(studentDTO);
        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void read() {
        //Arrange
        StudentDTO expectedStudentDTO = TestUtils.generateStudentDto(1L, "pepe", null, null, null);
        Long studentId = 1L;
        when(studentDAO.findById(1L)).thenReturn(expectedStudentDTO);
        //Act
        StudentDTO studentDTO = service.read(studentId);
        //Assert
        verify(studentDAO, atLeastOnce()).findById(studentId);
        assertThat(expectedStudentDTO).usingRecursiveComparison().isEqualTo(studentDTO);

    }

    @Test
    void update() {
        //Arrange
        StudentDTO studentDTO = TestUtils.generateStudentDto(1L, "pepe", null, null, null);
        //Act
        service.update(studentDTO);
        //Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    void delete() {
        //Arrange
        Long studentId = 1L;
        //Act
        service.delete(studentId);
        //Assert
        verify(studentDAO, atLeastOnce()).delete(studentId);
    }

    @Test
    void getAll() {
        //Arrange
        Set<StudentDTO> expectedStudentsDTO = TestUtils.getAllStudents();
        Long studentId = 1L;
        when(studentRepository.findAll()).thenReturn(expectedStudentsDTO);
        //Act
        Set<StudentDTO> studentsDTO = service.getAll();
        //Assert
        assertThat(expectedStudentsDTO).usingRecursiveComparison().isEqualTo(studentsDTO);
    }
}