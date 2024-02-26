package com.meli.obtenerdiploma.unity.controller;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerUnity {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    // ----------------------------------------------------- analyzeScores
    // -----------------------------------------------------
    @Test
    public void analyzeScoresTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Luna", "Sin mensaje", 9.00, List.of(new SubjectDTO("Matematica", 9.00)));
        // Act:
        obtenerDiplomaController.analyzeScores(param.getId());
        // Assert:
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(param.getId());
    }

}
