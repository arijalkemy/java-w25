package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Analizar promedios (Controller) - Éxito")
    public void analyzeScoresCorrect() {
        StudentDTO expectedStudent = MockBuilder.buildExpectedStudent(1L);
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(expectedStudent);

        StudentDTO currentStudent = obtenerDiplomaController.analyzeScores(expectedStudent.getId());

        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(1L);
        assertEquals(expectedStudent, currentStudent);
    }
}
