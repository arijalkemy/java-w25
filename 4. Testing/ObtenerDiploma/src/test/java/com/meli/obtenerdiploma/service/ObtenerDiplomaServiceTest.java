package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresOkLowAverage(){
        // arrange
        StudentDTO mockStudent = new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0.00,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                0.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                0.0
                        )
                )
        );
        StudentDTO studentExpected = new StudentDTO(
                1L,
                "Juan Manuel",
                "El alumno Juan Manuel ha obtenido un promedio de 0. Puedes mejorar.",
                0.00,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                0.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                0.0
                        )
                )
        );
        when(studentDAO.findById(1L)).thenReturn(mockStudent);
        //act
        StudentDTO studentObtainded = obtenerDiplomaService.analyzeScores(1L);
        // assert
        assertThat(studentObtainded).usingRecursiveComparison().isEqualTo(studentExpected);
    }
    @Test
    void analyzeScoresOkHighAverage(){
        // arrange
        StudentDTO mockStudent = new StudentDTO(
                1L,
                "Juan Manuel",
                "",
                0D,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )
        );
        StudentDTO studentExpected = new StudentDTO(
                1L,
                "Juan Manuel",
                "El alumno Juan Manuel ha obtenido un promedio de 10. Felicitaciones!",
                10.00,
                Arrays.asList(
                        new SubjectDTO(
                                "Matematicas",
                                10.0
                        ),
                        new SubjectDTO(
                                "Ciencias",
                                10.0
                        )
                )
        );
        when(studentDAO.findById(1L)).thenReturn(mockStudent);
        //act
        StudentDTO studentObtainded = obtenerDiplomaService.analyzeScores(1L);
        // assert
        assertThat(studentObtainded).usingRecursiveComparison().isEqualTo(studentExpected);
    }
    @Test
    void analyzeScoreStudentNotFound(){
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(1L));
    }

}
