package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock private ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScores() {
        //ARRANGE
        Long studentId = 1L;
        StudentDTO expectedStudentDao = new StudentDTO(studentId,
                "John",
                "Lorem",
                8.1, List.of());
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedStudentDao);
        //ACT
        StudentDTO resultStudentDto = obtenerDiplomaController.analyzeScores(studentId);
        //ASSERT

        assertEquals(expectedStudentDao, resultStudentDto);
    }
}