package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

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
    void calculateAverageOkTest(){
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        assertEquals(studentDTO.getAverageScore(), result.getAverageScore());
    }

    @Test
    void analyzeScoresTestThrowStudentNotFound() {
        when(studentDAO.findById(anyLong())).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(anyLong()));
    }

    @Test
    void getGreetingMessageOkTest() {
        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        assertEquals("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 7. Puedes mejorar.",result.getMessage());
    }

    @Test
    void getGreetingMessageCongratsOkTest() {

        SubjectDTO subject1 = new SubjectDTO("Matemática", 10.0);
        SubjectDTO subject2 = new SubjectDTO("Física", 10.0);
        SubjectDTO subject3 = new SubjectDTO("Química", 10.0);
        studentDTO.setSubjects(Arrays.asList(subject1, subject2, subject3));

        when(studentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentDTO.getId());

        assertEquals("El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de 10. Felicitaciones!",result.getMessage());
    }
}
