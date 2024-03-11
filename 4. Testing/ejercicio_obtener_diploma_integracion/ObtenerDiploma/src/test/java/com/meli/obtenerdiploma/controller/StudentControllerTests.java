package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
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
public class StudentControllerTests {
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    void registerStudent(){
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act
        controller.registerStudent(student);

        // Assert
        verify(service, atLeastOnce()).create(student);
    }

    @Test
    void getStudent(){
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(student.getId())).thenReturn(student);

        // Act
        StudentDTO studentResponse=controller.getStudent(student.getId());

        // Assert
        verify(service, atLeastOnce()).read(student.getId());
        assertEquals(student, studentResponse);
    }

    @Test
    void modifyStudent(){
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act
        controller.modifyStudent(student);

        // Assert
        verify(service, atLeastOnce()).update(student);
    }

    @Test
    void removeStudent(){
        // Arrange
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // Act
        controller.removeStudent(student.getId());

        // Assert
        verify(service, atLeastOnce()).delete(student.getId());
    }
    @Test
    void listStudents(){
        // Arrange
        Set<StudentDTO> students=TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);

        // Act
        Set<StudentDTO> studentsResponse=controller.listStudents();

        // Assert
        verify(service, atLeastOnce()).getAll();
        assertEquals(students, studentsResponse);
    }
}
