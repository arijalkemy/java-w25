package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)



class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks ObtenerDiplomaController obtenerDiplomaController;


    @Test
    void analyzeScoresTestOk() {
        //Arrange
        Long studentId = 5L;
        StudentDTO expectedStudent = new StudentDTO(1L, "Carlos", "Melo", 5.5, new ArrayList<>());
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedStudent);

        //Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(studentId);
        //Result
        assertEquals(expectedStudent,result);
        verify(obtenerDiplomaService,times(1)).analyzeScores(studentId);
    }
}