package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

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
    void createTestOk() {
        //ARRANGE
        StudentDTO expectedStudentDao = new StudentDTO(1L,
                "John",
                "Lorem",
                8.1,
                List.of()
        );

        //ACT
        //Método void por lo que no se puede comprobar
        // si devuelve algo simplemente que se llame
        studentService.create(expectedStudentDao);

        //ASSERT

        verify(studentDAO, atLeast(1)).save(expectedStudentDao);
    }

    @Test
    void read() {
        //ARRANGE
        Long studentId = 1L;
        StudentDTO expectedStudentDao = new StudentDTO(1L,
                "John",
                "Lorem",
                8.1,
                List.of()
        );

        when(studentDAO.findById(studentId)).thenReturn(expectedStudentDao);

        //ACT
        StudentDTO resultStundentDto = studentService.read(studentId);
        //ASSERT
        assertEquals(expectedStudentDao, resultStundentDto);

    }

    @Test
    void update() {
        //ARRANGE
        StudentDTO expectedStudentDao = new StudentDTO(1L,
                "John",
                "Lorem",
                8.1,
                List.of()
        );

        //ACT
        //Método void por lo que no se puede comprobar
        // si devuelve algo simplemente que se llame
        studentService.update(expectedStudentDao);

        //ASSERT

        verify(studentDAO, atLeast(1)).save(expectedStudentDao);
    }

    @Test
    void delete() {
        //ARRANGE
        Long studentId = 1L;

        //ACT
        //Método void por lo que no se puede comprobar
        // si devuelve algo simplemente que se llame
        studentService.delete(studentId);
        //ASSERT

        verify(studentDAO, atLeast(1)).delete(studentId);
    }

    @Test
    void getAllTestOk() {
        //ARRANGE
        StudentDTO student = new StudentDTO(1L,
                "John",
                "Lorem",
                8.1,
                List.of()
        );
        Set<StudentDTO> expectedSetStudent = Set.of(student);
        when(studentRepository.findAll()).thenReturn(expectedSetStudent);
        //ACT

        Set<StudentDTO> result = studentService.getAll();
        //ASSERT
        assertEquals(expectedSetStudent, result);
    }
}