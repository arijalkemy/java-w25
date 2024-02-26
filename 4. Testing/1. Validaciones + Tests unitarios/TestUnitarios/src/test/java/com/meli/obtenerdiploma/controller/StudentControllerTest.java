package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(7.0);
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 5.0);
        studentDTO.setSubjects(Arrays.asList(subject1, subject2, subject3));
    }

    @Test
    void registerStudentTestOk() {
        //Arrange

        //Act
        doNothing().when(studentService).create(this.studentDTO);

        ResponseEntity<?> result = studentController.registerStudent(this.studentDTO);

        //Assert
        assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    void registerStudentTestNull() {
        //Arrange
        StudentDTO studentNull = null;
        //Act & Assert
        doThrow(new IllegalArgumentException()).when(studentService).create(studentNull);

        assertThrows(IllegalArgumentException.class, () -> studentController.registerStudent(studentNull));
    }

    @Test
    void getStudentTestOk() {
        //Arrange
        StudentDTO expected = this.studentDTO;

        //Act
        when(studentService.read(this.studentDTO.getId())).thenReturn(this.studentDTO);
        StudentDTO result = studentController.getStudent(this.studentDTO.getId());

        //Assert
        assertEquals(expected, result);
    }

    @Test
    void deleteStudentTestOk() {
        //Arrange
        doNothing().when(studentService).delete(this.studentDTO.getId());

        //Act
        ResponseEntity<?> result = studentController.removeStudent(this.studentDTO.getId());

        //Assert
        assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    void deleteStudentTestNull() {
        //Arrange
        StudentDTO studentNull = null;
        //Act & Assert
        doThrow(new IllegalArgumentException()).when(studentService).delete(studentNull.getId());

        assertThrows(IllegalArgumentException.class, () -> studentController.removeStudent(studentNull.getId()));
    }

    @Test
    void modifyStudentTestOk() {
        //Arrange
        doNothing().when(studentService).update(this.studentDTO);

        //Act
        ResponseEntity<?> result = studentController.modifyStudent(this.studentDTO);

        //Assert
        assertEquals(ResponseEntity.ok().build(), result);
    }

    @Test
    void modifyStudentTestNull() {
        //Arrange
        StudentDTO studentNull = null;
        //Act & Assert
        doThrow(new IllegalArgumentException()).when(studentService).update(studentNull);

        assertThrows(IllegalArgumentException.class, () -> studentController.modifyStudent(studentNull));
    }

    @Test
    void listStudentsTestOk() {
        //Arrange
        Set<StudentDTO> studentList = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            StudentDTO student = new StudentDTO();
            student.setId((long) i);
            student.setStudentName("Student " + i);
            student.setAverageScore((double) i);
            SubjectDTO subject1 = new SubjectDTO("Matemática", (double) i);
            SubjectDTO subject2 = new SubjectDTO("Física", (double) i);
            SubjectDTO subject3 = new SubjectDTO("Química", (double) i);
            student.setSubjects(Arrays.asList(subject1, subject2, subject3));
            studentList.add(student);
        }
        studentList.add(this.studentDTO);
        when(studentService.getAll()).thenReturn(studentList);

        //Act
        Set<StudentDTO> result = studentController.listStudents();

        //Assert
        assertEquals(studentList, result);
    }

    @Test
    void listStudentsTestEmpty() {
        //Arrange
        Set<StudentDTO> studentList = new HashSet<>();
        when(studentService.getAll()).thenReturn(studentList);

        //Act
        Set<StudentDTO> result = studentController.listStudents();

        //Assert
        assertEquals(studentList, result);
    }
}
