package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;


    /*@Test
    void calculateAverageTest(){
        //ARRANGE
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Math", 8.0),
                new SubjectDTO("History", 7.0),
                new SubjectDTO("Science", 9.0)
        );
        Double expectedAverage = 8.0;


        //ACT

        Double actualValue = obtenerDiplomaService
        //ASSERT
    }*/

    @Test
    @Disabled
    void getGreetingMessageTest() {
        //ARRANGE
        String studentName = "Pablito Perez";
        Double average = 7.333333333333333;
        String expectedValue = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";
        ObtenerDiplomaService obtenerDiplomaService2 = new ObtenerDiplomaService();
        //ACT
        String result = "";
        //ASSERT
        assertEquals(expectedValue, result);
    }

    @Test
    public void analyzeScoresTestOk() {
        //ARRANGE
        Long studentId = 1L;
        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Math", 8.0),
                new SubjectDTO("History", 7.0),
                new SubjectDTO("Science", 9.0)
        );

        StudentDTO student = new StudentDTO(studentId,
                "Pablito Perez",
                "",
                0.0,
                subjects);

        when(studentDAO.findById(studentId)).thenReturn(student);
        Double expectedAverage = 8.00;
        String expectedMessage = "El alumno Pablito Perez ha obtenido un promedio de 8. Puedes mejorar.";

        //ACT
        StudentDTO analyzedStudent = obtenerDiplomaService.analyzeScores(studentId);

        //ASSERT
        assertEquals(expectedAverage, analyzedStudent.getAverageScore());

        assertEquals(expectedMessage, analyzedStudent.getMessage());

    }

    @Test
    public void analyzeScoresTestThrowsNotFound(){
        when(studentDAO.findById(anyLong())).thenReturn(List.of());

    }

}
