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
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresTestOk(){
        //Arrange
        Long studentId = anyLong();
        StudentDTO expectedResult = ObjectFactory.createStudentDTOWithAverageAboveNine();

        //Act
        when(studentDAO.findById(studentId)).thenReturn(expectedResult);

        StudentDTO actual = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedResult,actual);
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
