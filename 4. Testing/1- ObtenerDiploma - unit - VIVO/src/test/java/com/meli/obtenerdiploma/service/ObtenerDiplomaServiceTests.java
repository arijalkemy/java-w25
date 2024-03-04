package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    private IStudentDAO iStudentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void calculateAverageOK() {
        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 7.0);
        StudentDTO student = new StudentDTO(1L, "TestStudent", "", 0.0, Arrays.asList(subject1, subject2));

        double expected = 8.0;
        when(iStudentDAO.findById(1L)).thenReturn(student);

        // Act
        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertEquals(expected, studentDTO.getAverageScore());
    }

    @Test
    public void calculateAverageNegative_Border() {
        // Arrange
        Long id = 1L;
        SubjectDTO subject1 = new SubjectDTO("Matemática", -1.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", -2.0);
        StudentDTO student = new StudentDTO(id, "BorderTestStudent", "", 0.0, Arrays.asList(subject1, subject2));

        double expected = -1.5;
        Mockito.when(iStudentDAO.findById(id)).thenReturn(student);

        // Act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(id);

        // Assert
        Assertions.assertEquals(expected, actual.getAverageScore());
    }

    @Test
    @Disabled("** Hay que implementar una validación en el service para que funcione.")
    public void calculateAverageEmpty_Border() {
        // Arrange
        Long id = 1L;
        StudentDTO student = new StudentDTO();

        when(iStudentDAO.findById(id)).thenReturn(student);

        // Act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(id);

        // Assert
        Assertions.assertNull(actual.getAverageScore());
    }

    @Test
    public void getGreetingMessageOK() {
        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 7.0);
        StudentDTO student = new StudentDTO(1L, "TestStudent", "", 0.0, Arrays.asList(subject1, subject2));

        String expected = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " + 8 + ". Puedes mejorar.";
        when(iStudentDAO.findById(1L)).thenReturn(student);

        // Act
        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertEquals(expected, studentDTO.getMessage());
    }

    @Test
    public void getGreetingMessageWithHonorsOK() {
        // Arrange
        SubjectDTO subject1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Lengua", 10.0);
        StudentDTO student = new StudentDTO(1L, "TestStudent", "", 0.0, Arrays.asList(subject1, subject2));

        String expected = "El alumno " + student.getStudentName() + " ha obtenido un promedio de " + 10 + ". Felicitaciones!";
        when(iStudentDAO.findById(1L)).thenReturn(student);

        // Act
        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(1L);

        // Assert
        Assertions.assertEquals(expected, studentDTO.getMessage());
    }
}
