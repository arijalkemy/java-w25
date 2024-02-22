package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScores() {
        StudentDTO testStudent = new StudentDTO();
        testStudent.setId(1L);
        Mockito.when(iObtenerDiplomaService.analyzeScores(testStudent.getId())).thenReturn(testStudent);
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setId(1L);

        StudentDTO actual = obtenerDiplomaController.analyzeScores(testStudent.getId());

        assertEquals(actual.getId(), expectedStudent.getId());
    }
}