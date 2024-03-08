package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;


    @Test
    public void analyzeScoresTestOk() {
        //ARRANGE
        StudentDTO student = TestData.getStudent("Pablito Perez");

        when(studentDAO.findById(student.getId())).thenReturn(student);
        Double expectedAverage = 8.00;
        String expectedMessage = "El alumno Pablito Perez ha obtenido un promedio de 8. Puedes mejorar.";

        //ACT
        StudentDTO analyzedStudent = obtenerDiplomaService.analyzeScores(student.getId());

        //ASSERT
        assertNotNull(analyzedStudent);
        assertEquals(expectedAverage, analyzedStudent.getAverageScore());
        assertEquals(expectedMessage, analyzedStudent.getMessage());

    }



}
