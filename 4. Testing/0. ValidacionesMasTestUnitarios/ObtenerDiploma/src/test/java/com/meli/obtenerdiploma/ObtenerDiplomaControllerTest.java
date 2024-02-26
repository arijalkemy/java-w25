package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.factory.TestFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void shouldReturnStudentDtoOk(){
        //ARRANGE
        long id = 1L;
        StudentDTO expected = new StudentDTO(1L,"Julio","El alumno Julio ha obtenido un promedio de 10. Felicitaciones!",10.0,
                List.of(new SubjectDTO("Matematicas",12.3),
                        new SubjectDTO("Español",7.7)));
        //ACT
        StudentDTO actual = obtenerDiplomaController.analyzeScores(id);
        when(obtenerDiplomaService.analyzeScores(id)).thenReturn(expected);
        //ASSERT
        assertEquals(expected, obtenerDiplomaService.analyzeScores(id));
    }
}
