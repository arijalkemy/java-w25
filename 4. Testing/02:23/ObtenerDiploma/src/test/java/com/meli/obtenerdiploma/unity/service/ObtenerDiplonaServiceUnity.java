package com.meli.obtenerdiploma.unity.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplonaServiceUnity {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    // ----------------------------------------------------- analyzeScores
    // -----------------------------------------------------
    @Test
    public void analyzeScoresOkTest() {
        // Arrange:
        StudentDTO param = new StudentDTO(1L, "Luna", "Sin mensaje", 9.00, List.of(new SubjectDTO("Matematica", 9.00)));
        when(studentDAO.findById(param.getId())).thenReturn(param);
        // Act:
        StudentDTO response = obtenerDiplomaService.analyzeScores(param.getId());
        // Assert:
        verify(studentDAO, atLeastOnce()).findById(param.getId());
        assertEquals("El alumno Luna ha obtenido un promedio de 9.00. Felicitaciones!", response.getMessage());
    }

    @Test
    public void analyzeScoresNotOkTest() {
        // Arrange:
        Long id = 999L;
        // Act && Assert:
        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(id));
        verify(studentDAO, atLeastOnce()).findById(id);
    }
}
