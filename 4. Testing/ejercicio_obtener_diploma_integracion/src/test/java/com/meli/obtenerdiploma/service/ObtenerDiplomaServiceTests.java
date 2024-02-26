package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void averageScoreWellCalculated() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getExampleStudent();
        when(studentDAO.findById(stu.getId())).thenReturn(stu);
        // act
        service.analyzeScores(stu.getId());
        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(7.0, stu.getAverageScore());
    }

    @Test
    public void averageScoreOver9MessageWellWritten() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getExampleStudentWith9();
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Juan ha obtenido un promedio de 9.00. Felicitaciones!", stu.getMessage());
    }

    @Test
    public void averageScoreBelow9MessageWellWritten() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getExampleStudent();
        when(studentDAO.findById(stu.getId())).thenReturn(stu);

        // act
        service.analyzeScores(stu.getId());

        // assert
        verify(studentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Juan ha obtenido un promedio de 7.00. Puedes mejorar.", stu.getMessage());
    }
}
