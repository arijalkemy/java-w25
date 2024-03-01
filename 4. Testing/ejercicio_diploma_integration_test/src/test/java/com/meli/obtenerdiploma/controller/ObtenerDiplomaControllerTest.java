package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresOk(){
        StudentDTO mockStudent = new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0.00,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                0.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                0.0
                        )
                )
        );
        StudentDTO studentExpected = new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0.00,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                0.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                0.0
                        )
                )
        );
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(mockStudent);

        StudentDTO studentObtained = obtenerDiplomaController.analyzeScores(1L);

        assertThat(studentObtained).usingRecursiveComparison().isEqualTo(studentExpected);

    }
    @Test
    void analyzeScoresStudentNotFound(){
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(1L));
    }
}
