package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService diplomaServiceMock;
    @InjectMocks
    ObtenerDiplomaController diplomaController;

    @Test
    void analyzeScoresTestOk(){
        //Arrange
        Long studentId = anyLong();
        StudentDTO expectedResult = ObjectFactory.createStudentDTOWithAverageAboveNine();

        //Act
        when(diplomaServiceMock.analyzeScores(studentId)).thenReturn(expectedResult);

        StudentDTO actual = diplomaController.analyzeScores(studentId);

        //Assert
        assertEquals(expectedResult,actual);
    }
}
