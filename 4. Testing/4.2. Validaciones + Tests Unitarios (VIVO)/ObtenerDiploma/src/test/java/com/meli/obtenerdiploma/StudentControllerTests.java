package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {
    @Mock
    private StudentService studentService;
    @InjectMocks
    private StudentController studentController;

    private StudentDTO createStudent(Long studentId) {
        return new StudentDTO(
                studentId,
                "Juan Perez",
                null,
                null,
                List.of(
                        new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Lengua", 9.0)
                )
        );
    }

    @Test
    void registerStudentTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO stu = createStudent(studentId);
        //Act
        studentController.registerStudent(stu);
        //Assert
        verify(studentService, atLeast(1)).create(stu);
    }

    @Test
    void getStudentTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO stu = createStudent(studentId);
        //Act
        when(studentService.read(studentId)).thenReturn(stu);
        //Assert
        assertEquals(stu, studentController.getStudent(studentId));
    }

    @Test
    void modifyStudentTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO stu = createStudent(studentId);
        //Act
        studentController.modifyStudent(stu);
        //Assert
        verify(studentService, atLeast(1)).update(stu);
    }

    @Test
    void removeStudentTest() {
        //Arrange
        Long studentId = 1L;
        //Act
        studentController.removeStudent(studentId);
        //Assert
        verify(studentService, atLeast(1)).delete(studentId);
    }

    @Test
    void listStudentsTest() {
        //Arrange
        Set<StudentDTO> expected = Set.of(
                createStudent(1L),
                createStudent(2L)
        );
        //Act
        when(studentService.getAll()).thenReturn(expected);
        //Assert
        assertEquals(expected, studentController.listStudents());
    }
}
