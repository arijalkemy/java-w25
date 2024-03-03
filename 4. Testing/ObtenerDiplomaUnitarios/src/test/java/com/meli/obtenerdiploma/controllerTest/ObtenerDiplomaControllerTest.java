package com.meli.obtenerdiploma.controllerTest;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void analyzeScoresOk(){
        //ARRANGE
        StudentDTO studentDTOExpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));

        Mockito.when(obtenerDiplomaService.analyzeScores(1L)).thenReturn(studentDTOExpected);
        //ACT
        StudentDTO analyzedStudent = obtenerDiplomaController.analyzeScores(1L);
        //ASSERT
        assertEquals(studentDTOExpected, analyzedStudent);
    }
    @Test
    void analyzeScoresStudentNotFound(){
        Mockito.when(obtenerDiplomaService.analyzeScores(Mockito.anyLong())).thenThrow(StudentNotFoundException.class);
        //ACT - ASSERT
        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(1L));
    }
}

