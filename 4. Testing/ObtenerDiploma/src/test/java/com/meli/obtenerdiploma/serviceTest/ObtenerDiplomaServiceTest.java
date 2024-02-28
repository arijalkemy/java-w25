package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresTest(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));
        StudentDTO studentDTOExpected = new StudentDTO(1L, "Pedro", "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" , 2.00, subjectDTOList);
        StudentDTO studentDTOResult;


        when(studentDAO.findById(anyLong())).thenReturn(studentDTOExpected);

        //ACT
        studentDTOResult = obtenerDiplomaService.analyzeScores(8L);
        //ASSERT
        assertEquals(studentDTOExpected,studentDTOResult);
    }



}
