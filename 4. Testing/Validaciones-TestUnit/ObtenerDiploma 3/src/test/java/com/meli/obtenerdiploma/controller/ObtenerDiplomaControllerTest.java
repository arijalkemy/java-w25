package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.FactoryStudent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    private FactoryStudent f = new FactoryStudent();

    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresTestOK(){
        //Arrange
        Long studentId = 2L;
        StudentDTO expected = f.getStudentObtenerDiplomaExpectedTest();
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expected);
        //Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(studentId);
        //Assert
        assertEquals(expected, result);
    }

}
