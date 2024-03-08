package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.utils.TestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScores() {
        //ARRANGE
        StudentDTO studentDTO = TestData.getStudent("John Biden");
        //when(service.analyzeScores(studentDTO.getId())).thenReturn(studentDTO);

        //ACT
        obtenerDiplomaController.analyzeScores(studentDTO.getId());

        //ASSERT
        verify(service,atLeastOnce()).analyzeScores(studentDTO.getId());
    }
}