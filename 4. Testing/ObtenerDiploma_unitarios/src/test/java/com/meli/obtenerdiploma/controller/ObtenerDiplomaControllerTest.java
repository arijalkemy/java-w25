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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {


@Mock
    IObtenerDiplomaService service;
@InjectMocks
    ObtenerDiplomaController controller;

    private StudentDTO studentDTO;

@BeforeEach
    void setUp() {
    studentDTO = new StudentDTO();
    studentDTO.setStudentName("Juan");
    studentDTO.setAverageScore(7.0);
    studentDTO.setId(1L);
    SubjectDTO subject1 = new SubjectDTO("Matemática", 9.0);
    SubjectDTO subject2 = new SubjectDTO("Física", 7.0);
    SubjectDTO subject3 = new SubjectDTO("Química", 6.0);
    studentDTO.setSubjects(List.of(subject1, subject2, subject3));
    }

    @Test
    void analyzeScoresOK() {

        when(service.analyzeScores(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO result = controller.analyzeScores(studentDTO.getId());

        assertEquals(studentDTO, result);
    }
    @Test
    void analyzeScoresNull() {

        when(service.analyzeScores(studentDTO.getId())).thenReturn(null);

        StudentDTO result = controller.analyzeScores(studentDTO.getId());

        assertNull(result);
    }

    @Test
    void analyzeScoresNotFound() {

        when(service.analyzeScores(anyLong())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> controller.analyzeScores(studentDTO.getId()));
    }
}