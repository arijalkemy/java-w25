package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.assertj.core.matcher.AssertionMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoreWithCongratulationsMessage(){
        //Arrange
        StudentDTO foundStudent = new StudentDTO(1L, "Estudiante Testeado", null, null,
                List.of(new SubjectDTO("Matematicas", 9.0), new SubjectDTO("Ciencias naturales", 10.0)));
        Mockito.when(studentDAO.findById(1L)).thenReturn(foundStudent);
        String expectedMessage = "El alumno Estudiante Testeado ha obtenido un promedio de 9,5. Felicitaciones!";
        double expectedAverage = (foundStudent.getSubjects().get(0).getScore() + foundStudent.getSubjects().get(1).getScore())/2;
        StudentDTO expectedStudent = new StudentDTO(1L, "Estudiante Testeado", expectedMessage, expectedAverage,
                List.of(new SubjectDTO("Matematicas", 9.0), new SubjectDTO("Ciencias naturales", 10.0)));
        //Act
        StudentDTO resultStudent = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        Assertions.assertEquals(resultStudent.getMessage(), expectedMessage);
    }
    @Test
    void analyzeScoreFailedMessage(){
        //Arrange
        StudentDTO foundStudent = new StudentDTO(1L, "Estudiante Testeado", null, null,
                List.of(new SubjectDTO("Matematicas", 9.0), new SubjectDTO("Ciencias naturales", 8.0)));
        Mockito.when(studentDAO.findById(1L)).thenReturn(foundStudent);
        String expectedMessage = "El alumno Estudiante Testeado ha obtenido un promedio de 8,5. Puedes mejorar.";
        double expectedAverage = (foundStudent.getSubjects().get(0).getScore() + foundStudent.getSubjects().get(1).getScore())/2;
        //Act
        StudentDTO resultStudent = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        Assertions.assertEquals(resultStudent.getMessage(), expectedMessage);
    }
    @Test
    void analyzeScoreAverageTestOk(){
        //Arrange
        StudentDTO foundStudent = new StudentDTO(1L, "Estudiante Testeado", null, null,
                List.of(new SubjectDTO("Matematicas", 9.0), new SubjectDTO("Ciencias naturales", 10.0)));
        Mockito.when(studentDAO.findById(1L)).thenReturn(foundStudent);
        String expectedMessage = "El alumno Estudiante Testeado ha obtenido un promedio de 9,5. Felicitaciones!";
        double expectedAverage = (foundStudent.getSubjects().get(0).getScore() + foundStudent.getSubjects().get(1).getScore())/2;
        StudentDTO expectedStudent = new StudentDTO(1L, "Estudiante Testeado", expectedMessage, expectedAverage,
                List.of(new SubjectDTO("Matematicas", 9.0), new SubjectDTO("Ciencias naturales", 10.0)));
        //Act
        StudentDTO resultStudent = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        Assertions.assertEquals(resultStudent.getAverageScore(), 9.5);
    }


}
