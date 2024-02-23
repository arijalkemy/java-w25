package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static com.meli.obtenerdiploma.util.ObjectFactory.createExpectedStudent;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresTestOk() {
        //Arrange
        Long studentId = 1L;
        StudentDTO student = createExpectedStudent(studentId);
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenReturn(student);
        //Act
        StudentDTO result = obtenerDiplomaController.analyzeScores(student.getId());
        //Assert
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(studentId);
        assertEquals(student, result);
    }
}
