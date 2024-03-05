package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.*;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresOk() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Juan",
                null,
                7.0,
                List.of(
                        new SubjectDTO("Matematica", 6D),
                        new SubjectDTO("Quimica",10D)
                ));

        // Act
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        // Assert
        assertEquals(studentDTO, obtenerDiplomaService.analyzeScores(studentDTO.getId()));
    }

    @Test
    void analyzeScoresStudentWithoutSubjects() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Juan",
                "Mensaje de prueba",
                7.0,
                List.of());

        // Act
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        // Assert
        assertEquals(studentDTO, obtenerDiplomaService.analyzeScores(studentDTO.getId()));
    }

    @Test
    void analyzeScoresStudentNoArgs() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();

        // Act
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        // Assert
        assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(studentDTO.getId()));
    }
}