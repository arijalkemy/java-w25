package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {
    @Mock
    StudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO createStudentDTO() {
        return new StudentDTO(1L, "Juan", null, null, Arrays.asList(
                new SubjectDTO("Matemáticas", 10D),
                new SubjectDTO("Lengua", 9D),
                new SubjectDTO("Ciencias", 8D),
                new SubjectDTO("Historia", 7D),
                new SubjectDTO("Geografía", 6D)
        ));
    }

    @Test
    void testAnalyzeScores() {
        // Arrange
        Long studentId = 1L;
        StudentDTO studentDTO = createStudentDTO();
        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        // Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        // Assert
        assertEquals(studentDTO, result);
    }
}
