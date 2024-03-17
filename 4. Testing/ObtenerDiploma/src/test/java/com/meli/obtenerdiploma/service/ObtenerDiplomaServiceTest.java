package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private StudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresAVGLess9(){
        //ARRANGE
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0D,
                List.of(new SubjectDTO("Matematicas",9D),
                        new SubjectDTO("Fisica", 7D),
                        new SubjectDTO("Quimica", 6D)));

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);
        //ACT
        StudentDTO response = obtenerDiplomaService.analyzeScores(studentId);
        //ASSERT
        assertThat(studentDTO).isEqualTo(response);
    }
    @Test
    public void analyzeScoresAVGGreater9(){
        //ARRANGE
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0D,
                List.of(new SubjectDTO("Matematicas",9D),
                        new SubjectDTO("Fisica", 10D),
                        new SubjectDTO("Quimica", 9D)));

        when(studentDAO.findById(studentId)).thenReturn(studentDTO);
        //ACT
        StudentDTO response = obtenerDiplomaService.analyzeScores(studentId);
        //ASSERT
        assertThat(studentDTO).isEqualTo(response);
    }

}
