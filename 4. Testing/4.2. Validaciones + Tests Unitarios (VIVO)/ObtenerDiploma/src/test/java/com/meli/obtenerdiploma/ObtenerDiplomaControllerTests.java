package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {
    @Mock
    private ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    private StudentDTO createStudent(Long studentId) {
        return new StudentDTO(
                studentId,
                "Juan Perez",
                "Felicitaciones",
                9.5,
                List.of(
                        new SubjectDTO("Matematica", 10.0),
                        new SubjectDTO("Lengua", 9.0)
                )
        );
    }

    @Test
    void testAnalyzeScores() {
        // Arrange
        Long studentId = 1L;
        StudentDTO expected = createStudent(studentId);
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expected);
        // Act
        StudentDTO response = obtenerDiplomaController.analyzeScores(studentId);
        // Assert
        assertEquals(expected, response);
    }
}
