package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;



import static com.meli.obtenerdiploma.util.ObjectFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @DisplayName("US02-")
    @Test
    void analyzeScoresTest() {
        //ARRANGE
        Long studentId = 1L;
        StudentDTO mockStudent = createMockStudent(studentId);
        StudentDTO expectedStudentDTO = createExpectedStudent(studentId);
        when(studentDAO.findById(studentId)).thenReturn(mockStudent);
        //ACT
        StudentDTO resultStudentDTO = obtenerDiplomaService.analyzeScores(studentId);
        //ASSERT
        assertEquals(expectedStudentDTO.getAverageScore(), resultStudentDTO.getAverageScore());
    }




}
