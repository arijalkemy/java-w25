package com.meli.obtenerdiploma.unitTest.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.unitTest.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService diplomaService;
    @InjectMocks
    ObtenerDiplomaController diplomaController;

    @Test
    void analyzeScoresTest(){
        //Arrange
        Long studentID = 0L;
        StudentDTO expectedStudent = ObjectFactory.createStudentDTOWithAverageAboveNine();
        when(diplomaService.analyzeScores(studentID)).thenReturn(expectedStudent);

        //Act
        StudentDTO actualStudent = diplomaController.analyzeScores(studentID);

        //Assert
        assertEquals(expectedStudent, actualStudent);
    }
}
