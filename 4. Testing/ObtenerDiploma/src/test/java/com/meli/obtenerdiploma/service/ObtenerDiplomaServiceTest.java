package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScoresTest() {

        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));
        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);
        double averageExpected = (5.0+8.0+9.0)/3;

        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //Act
        StudentDTO studentWithData = obtenerDiplomaService.analyzeScores(1L);

        //Assert
        assertEquals(studentDTO,studentWithData);
        assertEquals(averageExpected, studentWithData.getAverageScore());

    }

    @Test
    void analizeScoreValidMsgWhenAverageLessThan9(){

        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("matematicas",5.0));
        subjectDTOS.add(new SubjectDTO("español",8.0));
        subjectDTOS.add(new SubjectDTO("ingles",9.0));
        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);
        double averageExpected = (5.0+8.0+9.0)/3;
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //Act
        StudentDTO studentWithData = obtenerDiplomaService.analyzeScores(1L);
        String messageDiploma = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "+ new DecimalFormat("#.##").format(averageExpected)
                +". Puedes mejorar.";

        //Assert
        assertEquals(messageDiploma,studentWithData.getMessage());

    }


    @Test
    void analizeScoreValidMsgWhenAverageMoreThan9(){

        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        subjectDTOS.add(new SubjectDTO("matematicas",10.0));
        subjectDTOS.add(new SubjectDTO("español",9.0));
        subjectDTOS.add(new SubjectDTO("ingles",10.0));
        studentDTO.setStudentName("Andres");
        studentDTO.setSubjects(subjectDTOS);
        double averageExpected = (10.0+9.0+10.0)/3;
        when(studentDAO.findById(anyLong())).thenReturn(studentDTO);

        //Act
        StudentDTO studentWithData = obtenerDiplomaService.analyzeScores(1L);
        String messageDiploma = "El alumno " + studentDTO.getStudentName() + " ha obtenido un promedio de "+ new DecimalFormat("#.##").format(averageExpected)
                +". Felicitaciones!";

        //Assert
        assertEquals(messageDiploma,studentWithData.getMessage());

    }
}
