package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    
    @InjectMocks
    StudentService service;
    
    @Test
    void createStudent(){
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act
        service.create(student);

        // Assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void readStudent() {
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO studentResult=service.read(student.getId());

        // Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(student, studentResult);
    }

    @Test
    void updateStudent() {
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act
        service.update(student);

        // Assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void deleteStudent() {
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act
        service.delete(student.getId());

        // Assert
        verify(studentDAO, atLeastOnce()).delete(student.getId());
    }

    @Test
    void getAllStudents() {
        // Arrange
        Set<StudentDTO> students=TestUtilsGenerator.getStudentSet();
        when(studentRepository.findAll()).thenReturn(students);

        // Act
        Set<StudentDTO> studentsResult=service.getAll();

        // Assert
        verify(studentRepository, atLeastOnce()).findAll();
        assertEquals(students, studentsResult);
    }
}
