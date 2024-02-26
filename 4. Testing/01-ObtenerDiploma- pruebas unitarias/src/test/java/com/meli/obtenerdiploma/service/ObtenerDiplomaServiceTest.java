package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;



    @Test
    void setObtenerDiplomaServiceReturnsDTO(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        double averageExpected = (5.0+8.0+9.0)/3;

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);


        StudentDTO studentWithData = obtenerDiplomaService.analyzeScores(1L);


        assertEquals(studentDTO,studentWithData);

    }

    @Test
    void analizeScoreValidMsgWhenAverageLessThan9(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        double averageExpected = (5.0+8.0+9.0)/3;

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);


        StudentDTO studentWithData = obtenerDiplomaService.analyzeScores(1L);

        String messageDiploma = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "+ new DecimalFormat("#.##").format(averageExpected)
                +". Puedes mejorar.";

        assertEquals(messageDiploma,studentWithData.getMessage());

    }


    @Test
    void analizeScoreValidMsgWhenAverageMoreThan9(){
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",10.0));
        subjectDTOS.add(new SubjectDTO("español",9.0));
        subjectDTOS.add(new SubjectDTO("ingles",10.0));

        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);

        double averageExpected = (10.0+9.0+10.0)/3;

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);


        StudentDTO studentWithData = obtenerDiplomaService.analyzeScores(1L);

        String messageDiploma = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "+ new DecimalFormat("#.##").format(averageExpected)
                +". Felicitaciones!";

        assertEquals(messageDiploma,studentWithData.getMessage());

    }


}
