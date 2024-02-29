package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresTestAverageBelowNine() {
        //Arrange
        Long studentId = 0L;
        StudentDTO studentGenerated = ObjectFactory.createStudentDTOWithAverageBelowNine();
        double expectedAverageScored = studentGenerated
                .getSubjects()
                .stream()
                .mapToDouble(SubjectDTO::getScore)
                .reduce(0.0, Double::sum)/studentGenerated.getSubjects().size();
        String expectedMessage = "El alumno " + studentGenerated.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(expectedAverageScored)
                + ". Puedes mejorar.";

        when(studentDAO.findById(studentId)).thenReturn(studentGenerated);

        //Act
        StudentDTO student = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedAverageScored, student.getAverageScore());
        assertEquals(expectedMessage, student.getMessage());

    }
    @Test
    public void analyzeScoresTestAverageAboveNine() {
        //Arrange
        Long studentId = 0L;
        StudentDTO studentGenerated = ObjectFactory.createStudentDTOWithAverageAboveNine();
        double expectedAverageScored = studentGenerated
                .getSubjects()
                .stream()
                .mapToDouble(SubjectDTO::getScore)
                .reduce(0.0, Double::sum)/studentGenerated.getSubjects().size();
        String expectedMessage = "El alumno " + studentGenerated.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(expectedAverageScored)
                + ". Felicitaciones!";

        when(studentDAO.findById(studentId)).thenReturn(studentGenerated);

        //Act
        StudentDTO student = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedAverageScored, student.getAverageScore());
        assertEquals(expectedMessage, student.getMessage());

    }

    @Test
    public void analyzeScoresTestThrowsStudentNotFoundExceptionWhenIdIsWrong() {
        //Arrange
        Long studentId = 1L;
        doThrow(StudentNotFoundException.class).when(studentDAO).findById(studentId);

        //Act and assert
        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(studentId));
    }


}
