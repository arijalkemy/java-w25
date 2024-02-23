package com.meli.obtenerdiploma.service;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static com.meli.obtenerdiploma.util.ObjectFactory.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;
    @InjectMocks
    StudentService studentService;

    @Test
    void createTestOk() {
        //ARRANGE
        StudentDTO student = createMockStudent(1L);
        //ACT & ASSERT
        studentService.create(student);
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void updateTestOk() {
        //ARRANGE
        StudentDTO student = createMockStudent(2L);
        //ACT & ASSERT
        studentService.update(student);
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void deleteTestOk() {
        StudentDTO student = createMockStudent(1L);
        studentService.delete(student.getId());
        verify(studentDAO, atLeastOnce()).delete(student.getId());
    }

    @Test
    void readTestOk() {
        Long studentID = 5L;
        //ARRANGE
        StudentDTO student = createMockStudent(studentID);
        when(studentDAO.findById(studentID)).thenReturn(student);
        //ACT
        StudentDTO readStudent = studentService.read(studentID);
        // ASSERT
        verify(studentDAO, atLeastOnce()).findById(studentID);
        assertEquals(student, readStudent);
    }

    @Test
    void getAllTestOk() {
        //ARRANGE
        Set<StudentDTO> students = createListStudentDTO();
        when(studentRepository.findAll()).thenReturn(students);
        //ACT
        Set<StudentDTO> readStudents = studentService.getAll();
        //ASSERT
        verify(studentRepository, atLeastOnce()).findAll();
        assertEquals(students, readStudents);
    }
}
