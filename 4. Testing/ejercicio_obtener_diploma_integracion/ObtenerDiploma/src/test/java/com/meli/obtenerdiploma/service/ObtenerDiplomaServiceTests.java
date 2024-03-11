package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    void averageScoreWellCalculated() {
        // Arrage
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO studentResponse= service.analyzeScores(student.getId());

        // Assert
        // Verificamos que findById() sea llamado al menos una vez
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(6.0, studentResponse.getAverageScore());
    }

    @Test
    void averageScoreOver9MessageWellWritten(){
        // Arrage
        StudentDTO student=TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO studentResponse= service.analyzeScores(student.getId());

        // Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 9,00. Felicitaciones!", studentResponse.getMessage());
    }

    @Test
    void averageScoreBelow9MessageWellWritten(){
        // Arrage
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO studentResponse= service.analyzeScores(student.getId());

        // Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 6,00. Puedes mejorar.", studentResponse.getMessage());
    }

    @Test
    void requestStudentNameMatchesResponseStudentName(){
        // Arrage
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO studentResponse= service.analyzeScores(student.getId());

        // Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("Marco", studentResponse.getStudentName());
    }

    @Test
    void requestStudentSubjectListMatchesResponseSubjectList(){
        // Arrage
        StudentDTO student=TestUtilsGenerator.getStudentWith3Subjects("Marco");

        List<SubjectDTO> initialList =new ArrayList<>();
        student.getSubjects().forEach(s->initialList.add(SerializationUtils.clone(s)));

        when(studentDAO.findById(student.getId())).thenReturn(student);

        // Act
        StudentDTO studentResponse= service.analyzeScores(student.getId());

        // Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertTrue(CollectionUtils.isEqualCollection(initialList, studentResponse.getSubjects()));
    }
}
