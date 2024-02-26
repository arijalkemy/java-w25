package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService diplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;


    @Test
    public void analyzeScoresOk(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        double averageExpected = (5.0+8.0+9.0)/3;

        studentDTO.setAverageScore(averageExpected);

       when(diplomaService.analyzeScores(anyLong())).thenReturn(studentDTO);

       StudentDTO studentResult = obtenerDiplomaController.analyzeScores(1L);

       assertEquals(averageExpected,studentResult.getAverageScore());


    }

}
