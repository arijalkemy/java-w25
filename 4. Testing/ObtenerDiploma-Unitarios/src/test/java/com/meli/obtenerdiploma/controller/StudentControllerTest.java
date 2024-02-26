package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static com.meli.obtenerdiploma.util.ObjectFactory.createListStudentDTO;
import static com.meli.obtenerdiploma.util.ObjectFactory.createMockStudent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentTest(){
        // ARRANGE
        StudentDTO mockStudent = createMockStudent(5L);
        // ACT
        studentController.registerStudent(mockStudent);
        // ASSERT
        verify(studentService, atLeastOnce()).create(mockStudent);
    }

    @Test
    public void getStudentTest(){
        // ARRANGE
        StudentDTO mockStudent = createMockStudent(5L);
        when(studentService.read(mockStudent.getId())).thenReturn(mockStudent);
        // ACT
        StudentDTO readStudent = studentController.getStudent(mockStudent.getId());
        // ASSERT
        verify(studentService, atLeastOnce()).read(mockStudent.getId());
        assertEquals(mockStudent, readStudent);
    }

    @Test
    public void modifyStudentTest(){
        // ARRANGE
        StudentDTO mockStudent = createMockStudent(5L);
        // ACT
        studentController.modifyStudent(mockStudent);
        // ASSERT
        verify(studentService, atLeastOnce()).update(mockStudent);
    }

    @Test
    public void removeStudentTest(){
        // ARRANGE
        StudentDTO mockStudent = createMockStudent(5L);
        // ACT
        studentController.removeStudent(mockStudent.getId());
        // ASSERT
        verify(studentService, atLeastOnce()).delete(mockStudent.getId());
    }

    @Test
    public void getAllStudentTest(){
        // ARRANGE
        Set<StudentDTO> students = createListStudentDTO();
        when(studentService.getAll()).thenReturn(students);
        // ACT
        Set<StudentDTO> readStudents = studentController.listStudents();
        // ASSERT
        verify(studentService, atLeastOnce()).getAll();
        assertEquals(students, readStudents);
    }


}
