package com.meli.obtenerdiploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;

class ObtenerDiplomaServiceTest {
    private IStudentDAO studentDAO;
    private IObtenerDiplomaService obtenerDiplomaService;

    @BeforeEach
    void setupData() {
        studentDAO = mock(StudentDAO.class);
        obtenerDiplomaService = new ObtenerDiplomaService(studentDAO);
    }

    @Test
    void testAnalyzeScores() {
        // arrange
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Matemáticas", 4.3d),
                new SubjectDTO("Física", 4d));
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        Double expectedAverageScore = (4.3d + 4d) / 2;
        String expectedGreetingMessage = "El alumno "
                + studentDTO.getStudentName()
                + " ha obtenido un promedio de "
                + new DecimalFormat("#.##")
                        .format(expectedAverageScore)
                + ((expectedAverageScore > 9)
                        ? ". Felicitaciones!"
                        : ". Puedes mejorar.");
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        // act
        StudentDTO studentDTOResult = obtenerDiplomaService.analyzeScores(studentDTO.getId());
        Double averageScoreResult = studentDTOResult.getAverageScore();
        String greetingMessage = studentDTOResult.getMessage();
        // assert
        assertEquals(expectedGreetingMessage, greetingMessage);
        assertEquals(expectedAverageScore, averageScoreResult);
    }

    @Test
    void testAnalyzeScoresWhenAverageScoreIsUpToNine() {
        // arrange
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Matemáticas", 15.586d),
                new SubjectDTO("Física", 15.5d));
        StudentDTO studentDTO = new StudentDTO(
                1L,
                "Roberto",
                "N/A",
                5.0,
                subjects);
        Double expectedAverageScore = (15.586d + 15.5d) / 2;
        String expectedGreetingMessage = "El alumno "
                + studentDTO.getStudentName()
                + " ha obtenido un promedio de "
                + new DecimalFormat("#.##")
                        .format(expectedAverageScore)
                + ((expectedAverageScore > 9)
                        ? ". Felicitaciones!"
                        : ". Puedes mejorar.");
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        // act
        StudentDTO studentDTOResult = obtenerDiplomaService.analyzeScores(studentDTO.getId());
        Double averageScoreResult = studentDTOResult.getAverageScore();
        String greetingMessage = studentDTOResult.getMessage();
        // assert
        assertEquals(expectedGreetingMessage, greetingMessage);
        assertEquals(expectedAverageScore, averageScoreResult);
    }
}
