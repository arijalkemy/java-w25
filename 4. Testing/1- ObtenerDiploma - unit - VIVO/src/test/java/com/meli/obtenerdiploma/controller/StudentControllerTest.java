package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.utils.TestUtilGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("RegisterStudent - return: void - parameters: StudentDTO")
    void registerStudentTestOK() {
        // Arrange
        StudentDTO student = TestUtilGenerator.generateStudentDTOWith3Subj();

        // Act
        studentController.registerStudent(student);

        // Assert
        verify(studentService, atLeastOnce()).create(student);
    }

    @Test
    @DisplayName("GetStudent - return: StudentDTO - parameters: Long")
    void getStudent() {
        // Arrange
        StudentDTO student = TestUtilGenerator.generateStudentDTOWith3Subj();

        // Act
        studentController.getStudent(student.getId());

        // Assert
        verify(studentService, atLeastOnce()).read(student.getId());
    }

    @Test
    @DisplayName("ModifyStudent - return: void - parameters: StudentDTO")
    void modifyStudent() {
        // Arrange
        StudentDTO student = TestUtilGenerator.generateStudentDTOWith3Subj();

        // Act
        studentController.modifyStudent(student);

        // Assert
        verify(studentService, atLeastOnce()).update(student);
    }

    @Test
    @DisplayName("RemoveStudent - return: void - parameters: Long")
    void removeStudent() {
        // Arrange
        StudentDTO student = TestUtilGenerator.generateStudentDTOWith3Subj();

        // Act
        studentController.removeStudent(student.getId());

        // Assert
        verify(studentService, atLeastOnce()).delete(student.getId());
    }

    @Test
    @DisplayName("ListStudents - return: Set<StudentDTO> - parameters: 0")
    void listStudents() {
        // Arrange

        // Act
        studentController.listStudents();

        // Assert
        verify(studentService, atLeastOnce()).getAll();
    }

}