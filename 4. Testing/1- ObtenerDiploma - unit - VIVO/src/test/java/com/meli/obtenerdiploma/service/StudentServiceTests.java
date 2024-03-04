package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService service;

    @Test
    @DisplayName("CreateStudent - return: void - parameters: 0")
    void createTestOK() {
        // Arrange
        SubjectDTO math = new SubjectDTO("Math", 9.0);
        SubjectDTO chemistry = new SubjectDTO("Chemistry", 7.0);
        StudentDTO studentDTO = new StudentDTO(1L, "Test", "Test", 8.0, List.of(math, chemistry));

        // Act
        service.create(studentDTO);

        // Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("ReadStudent - return: StudentDTO - parameters: Long")
    void readTestOK() {
        // Arrange
        Long id = 1L;
        SubjectDTO math = new SubjectDTO("Math", 9.0);
        SubjectDTO art = new SubjectDTO("Art", 7.0);
        StudentDTO expected = new StudentDTO(1L, "TestName", "Test", 8.0, List.of(math, art));

        when(studentDAO.findById(id)).thenReturn(expected);
        // Act
        StudentDTO result = service.read(1L);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("UpdateStudent - return: void - parameters: StudentDTO")
    void updateTestOK() {
        // Arrange
        SubjectDTO math = new SubjectDTO("Math", 9.0);
        SubjectDTO art = new SubjectDTO("Art", 7.0);
        StudentDTO studentDTO = new StudentDTO(1L, "TestName", "Test", 8.0, List.of(math, art));

        // Act
        service.update(studentDTO);

        // Assert
        verify(studentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    @DisplayName("DeleteStudent - return: void - parameters: Long")
    void deleteTestOK() {
        // Arrange
        Long id = 1L;

        // Act
        service.delete(id);

        // Assert
        verify(studentDAO, atLeastOnce()).delete(id);
    }

    @Test
    @DisplayName("GetAllStudents - return: Set<StudentDTO> - parameters: 0")
    void getAllTestOK() {
        // Arrange
        SubjectDTO math = new SubjectDTO("Math", 9.0);
        SubjectDTO art = new SubjectDTO("Math", 9.0);
        SubjectDTO history = new SubjectDTO("Math", 9.0);

        StudentDTO joe = new StudentDTO(1L, "Joe", "Joe Test", 9.0, List.of(math, art, history));
        StudentDTO john = new StudentDTO(2L, "John", "John Test", 9.0, List.of(math, art, history));
        StudentDTO james = new StudentDTO(3L, "James", "James Test", 9.0, List.of(math, art, history));

        Set<StudentDTO> expected = new HashSet<>();
        expected.add(joe);
        expected.add(john);
        expected.add(james);

        when(studentRepository.findAll()).thenReturn(expected);

        // Act
        Set<StudentDTO> result = service.getAll();

        // Assert
        assertEquals(expected, result);
    }
}
