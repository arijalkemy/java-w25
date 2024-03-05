package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeGoodScoresMessageOk() {
        //Arrange
        List<SubjectDTO> subjects = TestUtils.generateGoodSubjects();
        StudentDTO studentDTO = TestUtils.generateStudentDto(1L, "pepe", null, null, subjects);
        StudentDTO expectedStudentDto = TestUtils.generateGoodStudentDto();
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        //Act
        studentDTO = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(studentDTO.getMessage(), expectedStudentDto.getMessage());
        assertEquals(studentDTO.getAverageScore(), expectedStudentDto.getAverageScore());

    }

    @Test
    void analyzeBadScoresMessageOk() {
        //Arrange
        List<SubjectDTO> subjects = TestUtils.generateBadSubjects();
        StudentDTO studentDTO = TestUtils.generateStudentDto(1L, "pepe", null, null, subjects);
        StudentDTO expectedStudentDto = TestUtils.generateBadStudentDto();
        when(studentDAO.findById(1L)).thenReturn(studentDTO);
        //Act
        studentDTO = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(studentDTO.getMessage(), expectedStudentDto.getMessage());
        assertEquals(studentDTO.getAverageScore(), expectedStudentDto.getAverageScore());
    }
}