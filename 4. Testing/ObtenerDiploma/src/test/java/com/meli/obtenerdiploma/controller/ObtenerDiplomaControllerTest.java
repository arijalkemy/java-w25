package com.meli.obtenerdiploma.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    StudentDTO studentDto;

    @BeforeEach
    void setUp() {
        studentDto = new StudentDTO(
                1L,
                "Juan",
                null,
                7.0,
                List.of(
                        new SubjectDTO("Matematica", 6D),
                        new SubjectDTO("Quimica", 10D))
        );
    }

    @Test
    void analyzeScores() {
        when(obtenerDiplomaService.analyzeScores(studentDto.getId())).thenReturn(studentDto);
        assertEquals(studentDto, obtenerDiplomaController.analyzeScores(studentDto.getId()));
    }
}