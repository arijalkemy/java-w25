package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analizeScoresTest() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(7.33);
        studentDTO.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");
        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTO);

        StudentDTO devolucion = obtenerDiplomaController.analyzeScores(1L);

        Assertions.assertEquals(devolucion.getMessage(), studentDTO.getMessage());
        Assertions.assertEquals(studentDTO.getAverageScore(), devolucion.getAverageScore());
    }
}
