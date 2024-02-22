package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {
    @Mock
    IObtenerDiplomaService service;
    @Test
    void testAnalyzeScores() {
        StudentDTO testRq = new StudentDTO();
        StudentDTO expectedRq = new StudentDTO();
        Mockito.when(service.analyzeScores(testRq)).thenReturn(expectedRq);
        ObtenerDiplomaController controller = new ObtenerDiplomaController();
        controller.service = service;

        StudentDTO result = controller.analyzeScores(testRq);

        Assertions.assertEquals(result, expectedRq);
    }
}