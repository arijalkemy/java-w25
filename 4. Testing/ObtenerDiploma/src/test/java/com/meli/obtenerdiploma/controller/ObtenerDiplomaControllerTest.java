package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresTest() {
        //Arrange
        Long studentId = 1L;
        StudentDTO studentDTOExpected = Util.getStudenDtoComplete();
        StudentDTO studentDTOResult;
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(studentDTOExpected);

        //Act
        studentDTOResult=  obtenerDiplomaService.analyzeScores(studentId);
        //Assert
        assertEquals(studentDTOExpected,studentDTOResult);
    }
}