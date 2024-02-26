package com.meli.obtenerdiploma.services;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
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
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository repository;

    @InjectMocks
    StudentService service;

    @Test
    void createTest(){
        //ARRANGE
        StudentDTO studentExpected = new StudentDTO(3L, "Juan", "Test", 2.5, List.of( new SubjectDTO("Math", 5.0)));
        //ACT
        service.create(studentExpected);
        //ASSERT
        verify(studentDAO).save(studentExpected);

    }

    @Test
    void createNullStudentTest(){
        //ARRANGE
        StudentDTO student = null;
        //ACT
        service.create(student);
        //
        verify(studentDAO, never()).save(any(StudentDTO.class));
    }

    @Test
    void readTest(){
        //ARRANGE
        StudentDTO studentExpected = new StudentDTO(1L, "Juan", "Test", 2.5, List.of( new SubjectDTO("Math", 5.0)));
        when(studentDAO.findById(1L)).thenReturn(studentExpected);
        //ACT
        StudentDTO studentFounded = service.read(1L);
        //ASSERT
        assertEquals(studentExpected, studentFounded);
    }

    @Test
    void updateTest(){
        //ARRANGE

    }

}
