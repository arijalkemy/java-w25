package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaTest {

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresOk(){
        Long id = 1L;
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0D, List.of(new SubjectDTO("matematicas", 3D)));

        when(obtenerDiplomaService.analyzeScores(id)).thenReturn(expected);

        StudentDTO response = obtenerDiplomaController.analyzeScores(id);

        assertThat(expected).isEqualTo(response);
    }

    @Test
    public void analyzeScoresNotFound(){
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(anyLong()));
    }
}
