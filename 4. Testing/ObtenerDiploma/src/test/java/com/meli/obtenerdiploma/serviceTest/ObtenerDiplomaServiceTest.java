package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private StudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("analyzeScores -> when average is greater than 9 then return a congratulation message")
    void analyzeScoresCongratulationMessage() {
        //Arrange
        Long id = 1L;
        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Lengua", 10.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Ciencias", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);
        when(studentDAO.findById(id)).thenReturn(new StudentDTO(id, "Juan", "", 9.1, subjects));
        String expectedMessage = "El alumno Juan ha obtenido un promedio de 10. Felicitaciones!";
        Double expectedAverage = 10.0;

        //Act
        StudentDTO actualMessage = obtenerDiplomaService.analyzeScores(id);

        //Assert
        assertEquals(expectedMessage, actualMessage.getMessage());
        assertEquals(expectedAverage, actualMessage.getAverageScore());
    }

    @Test
    @DisplayName("analyzeScores -> when average is less than 9 then return a can be better message")
    void analyzeScoresCanBeBetterMessage() {
        //Arrange
        Long id = 1L;
        SubjectDTO subjectDTO = new SubjectDTO("Matemáticas", 3.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Lengua", 5.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Ciencias", 10.0);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subjectDTO);
        subjects.add(subjectDTO2);
        subjects.add(subjectDTO3);
        when(studentDAO.findById(id)).thenReturn(new StudentDTO(id, "Juan", "", 9.1, subjects));
        String expectedMessage = "El alumno Juan ha obtenido un promedio de 6. Puedes mejorar.";
        Double expectedAverage = 6.0;

        //Act
        StudentDTO actualMessage = obtenerDiplomaService.analyzeScores(id);

        //Assert
        assertEquals(expectedMessage, actualMessage.getMessage());
        assertEquals(expectedAverage, actualMessage.getAverageScore());
    }
}
