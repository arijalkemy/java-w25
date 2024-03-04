package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.utils.MockBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analizar promedios (Service) - Éxito")
    void analyzeScoresCorrect() {

        //ARRANGE - PREPARAR DATOS A USAR (PARAMETROS, TIPO DE DATO DE DEVOLUCION)
        StudentDTO expectedStudent = MockBuilder.buildExpectedStudent(1l);
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);

        //ACT - CORRER EL METODO
        when(studentDAO.findById(paramStudent.getId())).thenReturn(paramStudent);

        //ASSERT - COMPROBAR FUNCIONAMIENTO DEL MÉTODO
        assertThat(
                obtenerDiplomaService.analyzeScores(1L).getMessage())
                .isEqualTo(expectedStudent.getMessage()
                );
    }

    @Test
    @DisplayName("Encontrar por id (DAO) - Excepción")
    void findByIdException() {

        //ARRANGE - PREPARAR DATOS A USAR (PARAMETROS, TIPO DE DATO DE DEVOLUCION)
        StudentDTO paramStudent = MockBuilder.buildParamStudent(1L);

        //StudentDTO devolution = null;

        //when(studentDAO.findById(paramStudent.getId())).thenReturn(devolution);
        when(studentDAO.findById(any(Long.class))).thenThrow(StudentNotFoundException.class);
        assertThrows(StudentNotFoundException.class,
                () -> studentDAO.findById(paramStudent.getId()));
    }

}
