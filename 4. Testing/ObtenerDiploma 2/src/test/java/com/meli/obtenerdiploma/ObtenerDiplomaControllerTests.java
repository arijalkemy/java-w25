package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import utils.FactoryStudent;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    FactoryStudent f = new FactoryStudent();

    @Test
    public void analyzeScoreTestOK(){
        // Arrange
        Long studentIdParam = 1L;
        StudentDTO expected = f.getJuanStudent();
        // Act
        when(obtenerDiplomaService.analyzeScores(studentIdParam)).thenReturn(expected);
        // Assert
        Assertions.assertEquals(expected, obtenerDiplomaController.analyzeScores(studentIdParam));
    }

}
