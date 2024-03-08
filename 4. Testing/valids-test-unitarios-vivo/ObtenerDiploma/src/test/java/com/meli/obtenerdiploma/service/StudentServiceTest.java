package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.utils.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;


    @Test
    void create() {
        //ARRANGE
        StudentDTO student = TestData.getStudent("Nicolas Maduro");

        //ACT

        studentService.create(student);

        //ASSERT
        verify(studentDAO, times(1)).save(student);
    }

    @Test
    void read() {
        //ARRANGE

        StudentDTO student = TestData.getStudent("Vladimir Putin");

        when(studentDAO.findById(student.getId())).thenReturn(student);

        //ACT
        StudentDTO actualStudent = studentService.read(student.getId());

        //ASSERT
        assertNotNull(actualStudent);
        assertEquals(student.getId(),actualStudent.getId());
        assertEquals(student.getStudentName(),actualStudent.getStudentName());

    }

    @Test
    void update() {
        //ARRANGE

        StudentDTO student = TestData.getStudent("Gustavo Petro");

        //ACT
        studentService.update(student);

        //ASSERT
        verify(studentDAO, atLeast(1)).save(student);
    }

    @Test
    void delete() {
        //ARRANGE
        Long id = 1L;

        //ACT
        studentService.delete(id);

        //ASSERT
        verify(studentDAO, atLeastOnce()).delete(id);
    }

    @Test
    void getAll() {
        //ARRANGE
        Set<StudentDTO> studentDTOSet = TestData.getStudentSet();
        when(studentRepository.findAll()).thenReturn(studentDTOSet);

        //ACT
        Set<StudentDTO> actualStudents =  studentService.getAll();

        //ASSERT
        assertEquals(studentDTOSet.size(),actualStudents.size());
        assertEquals(studentDTOSet, actualStudents);

    }
}