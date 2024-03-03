package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDService;

    @Test
    void testAnalizeScoresLowOK(){
        //ARRANGE
        StudentDTO studentDTOexpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 0.0),new SubjectDTO("Science", 0.0)));
        Mockito.when(studentDAO.findById(1L)).thenReturn(studentDTOexpected);
        //ACT
        StudentDTO analyzedStudent = obtenerDService.analyzeScores(1L);
        //ASSERT
        assertNotNull(analyzedStudent);
        assertEquals("John Doe", analyzedStudent.getStudentName());
        assertEquals(Double.valueOf(0.0), analyzedStudent.getAverageScore());
        assertEquals(studentDTOexpected.getMessage(), analyzedStudent.getMessage());
        assertEquals(studentDTOexpected, analyzedStudent);
    }

    @Test
    void testAnalizeScoresHightOK(){
        //ARRANGE
        StudentDTO studentDTOexpected = new StudentDTO(1L, "John Doe", "Test", 2.5,
                List.of( new SubjectDTO("Math", 10.0),new SubjectDTO("Science", 10.0)));
        Mockito.when(studentDAO.findById(1L)).thenReturn(studentDTOexpected);
        //ACT
        StudentDTO analyzedStudent = obtenerDService.analyzeScores(1L);
        //ASSERT
        assertNotNull(analyzedStudent);
        assertEquals("John Doe", analyzedStudent.getStudentName());
        assertEquals(Double.valueOf(10.0), analyzedStudent.getAverageScore());
        assertEquals(studentDTOexpected.getMessage(), analyzedStudent.getMessage());
        assertEquals(studentDTOexpected, analyzedStudent);
    }

    @Test
    void testAnalizeScoresThrow(){
        Mockito.when(studentDAO.findById(Mockito.anyLong())).thenThrow(StudentNotFoundException.class);
        //ACT - ASSERT
        assertThrows(StudentNotFoundException.class, () -> obtenerDService.analyzeScores(1l));
    }
}
