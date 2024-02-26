package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setAverageScore(7.0);
        SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 5.0);
        studentDTO.setSubjects(Arrays.asList(subject1, subject2, subject3));
    }

    @Test
    void analyzeScoresOkTest(){
        when(obtenerDiplomaService.analyzeScores(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaController.analyzeScores(studentDTO.getId());

        assertEquals(studentDTO, result);
    }

    @Test
    void analyzeScoresStudentNotFoundTest() {
        when(obtenerDiplomaService.analyzeScores(anyLong())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaController.analyzeScores(999L));
    }
}
