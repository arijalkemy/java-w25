package com.meli.obtenerdiploma.services;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    void analizeScoresTest(){
        //ARRANGE
        StudentDTO studentDTOexpected = new StudentDTO(1L, "Juan", "Test", 2.5, List.of( new SubjectDTO("Math", 5.0)));

        //ACT
        when(studentDAO.findById(1L)).thenReturn(studentDTOexpected);

        StudentDTO currentStudentDto = service.analyzeScores(1L);
        //ASSERT
        assertEquals(studentDTOexpected, currentStudentDto);
    }






}
