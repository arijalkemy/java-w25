package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScores() {
        //Arrange
        Long studentId = 1L;
        StudentDTO expectedGoodStudent = TestUtils.generateGoodStudentDto();
        when(obtenerDiplomaService.analyzeScores(studentId)).thenReturn(expectedGoodStudent);
        //Act
        StudentDTO goodStudent = obtenerDiplomaController.analyzeScores(studentId);
        //Assert
        assertThat(expectedGoodStudent).usingRecursiveComparison().isEqualTo(goodStudent);

    }
}