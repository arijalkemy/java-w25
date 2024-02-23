package com.meli.obtenerdiploma.unitTest.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.unitTest.util.ObjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    void analyzeScoresAverageAboveNineTest(){
        //Arrange
        Long studentID = 0L;
        StudentDTO expectedStudent = ObjectFactory.createStudentDTOWithAverageAboveNine();

        when(studentDAO.findById(studentID)).thenReturn(expectedStudent);

        //Act
        StudentDTO actualStudent = diplomaService.analyzeScores(studentID);

        //Assert
        assertEquals(expectedStudent, actualStudent);
    }
    @Test
    void analyzeScoresAverageBelowNineTest(){
        //Arrange
        Long studentID = 0L;
        StudentDTO expectedStudent = ObjectFactory.createStudentDTOWithAverageBelowNine();

        when(studentDAO.findById(studentID)).thenReturn(expectedStudent);

        //Act
        StudentDTO actualStudent = diplomaService.analyzeScores(studentID);

        //Assert
        assertEquals(expectedStudent, actualStudent);
    }
}
