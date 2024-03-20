package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;


    @Test
    void analyzeScoresTestOk() {
        //ARRANGE
        Long studentId = 1L;
        StudentDTO expectedStudentDao = new StudentDTO(studentId,
                "John",
                "Lorem",
                8.1, List.of());

        //ACT
        when(studentDAO.findById(studentId)).thenReturn(expectedStudentDao);

        //ASSERT

        StudentDTO resultStudentDto = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(expectedStudentDao, resultStudentDto);
        assertEquals(expectedStudentDao.getId(), resultStudentDto.getId());

    }
}