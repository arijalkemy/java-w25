package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
   private StudentDAO studentDAO;
    @InjectMocks
   private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresOKTest() {
        // arrange
        StudentDTO expectedResult =  new StudentDTO(
                12L,
                "jorge",
                "El alumno jorge ha obtenido un promedio de 7.5. Puedes mejorar.",
                7.5,
                List.of(
                        new SubjectDTO(
                                "subject11",
                                7.5
                        )
                )
        );
        when(studentDAO.findById(12L)).thenReturn(
                 new StudentDTO(
                        12L,
                        "jorge",
                        "mensaje",
                        7.5,
                        List.of(
                                new SubjectDTO(
                                        "subject11",
                                        7.5
                                )
                        )
                )
        );
        //
        StudentDTO actual = obtenerDiplomaService.analyzeScores(12L);
        verify(studentDAO, atLeast(1)).findById(12L);
        assertEquals(expectedResult, actual);

    }
    @Test
    void analyzeScoresOKDiplomaDehonor() {
        // arrange
        StudentDTO expectedResult =  new StudentDTO(
                12L,
                "jorge",
                "El alumno jorge ha obtenido un promedio de 9.5. Felicitaciones!",
                9.5,
                List.of(
                        new SubjectDTO(
                                "subject11",
                                9.5
                        )
                )
        );
        when(studentDAO.findById(12L)).thenReturn(
                new StudentDTO(
                        12L,
                        "jorge",
                        "mensaje",
                        7.5,
                        List.of(
                                new SubjectDTO(
                                        "subject11",
                                        9.5
                                )
                        )
                )
        );
        //act
        StudentDTO actual = obtenerDiplomaService.analyzeScores(12L);
        verify(studentDAO, atLeast(1)).findById(12L);
        //assert
        assertEquals(expectedResult, actual);

    }

    @Test
    void studentNotFoundTest(){
        //
        long id = 12L;
        when(studentDAO.findById(id)).thenThrow( new StudentNotFoundException(id));
        //act
        assertThrows(StudentNotFoundException.class, ()-> obtenerDiplomaService.analyzeScores(12L));
    }

}