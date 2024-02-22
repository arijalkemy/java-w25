package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void name() {
    }

    @Test
    @DisplayName("Ejercicio2")
    void analyzeScoresOk() {
        //Arrange
        long studentId = 1L;
        StudentDTO studentDaoResult = new StudentDTO(1L, "Juan", null, 0.0, new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));

        StudentDTO expectedStudentDTO = new StudentDTO(1L, "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.333333333333333, new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));

        //Act
        when(studentDAO.findById(studentId)).thenReturn(studentDaoResult);
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedStudentDTO, result);
    }

    @Test
    void analyzeScoresStudentNotFound() {
        //Arrange
        long studentId = 3L;

        when(studentDAO.findById(studentId)).thenThrow(StudentNotFoundException.class);

        //Act Assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
    }

    @Test
    void analyzeScoresMessageOk() {
        //Arrange
        long studentId = 1L;
        StudentDTO studentDaoResult = new StudentDTO(1L, "Juan", null, 0.0, new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 10.0),
                new SubjectDTO("Química", 10.0)
        )));
        String expectedMessage = "El alumno Juan ha obtenido un promedio de 10. Felicitaciones!";
        when(studentDAO.findById(studentId)).thenReturn(studentDaoResult);
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    void analyzeScoresMessageFail() {
        //Arrange
        long studentId = 1L;
        StudentDTO studentDaoResult = new StudentDTO(1L, "Juan", null, 0.0, new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 5.0),
                new SubjectDTO("Física", 5.0),
                new SubjectDTO("Química", 5.0)
        )));
        String expectedMessage = "El alumno Juan ha obtenido un promedio de 5. Puedes mejorar.";
        when(studentDAO.findById(studentId)).thenReturn(studentDaoResult);
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    void analyzeScoresAverageOk() {
        //Arrange
        long studentId = 1L;
        StudentDTO studentDaoResult = new StudentDTO(1L, "Juan", null, 0.0, new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));
        double expectedAverage = 7.333333333333333;
        when(studentDAO.findById(studentId)).thenReturn(studentDaoResult);
        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedAverage, result.getAverageScore());
    }

}