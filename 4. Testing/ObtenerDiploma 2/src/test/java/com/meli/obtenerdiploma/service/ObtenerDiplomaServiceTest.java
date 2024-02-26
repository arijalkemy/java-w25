package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores_Ok_congrats(){
        //Arrange
        StudentDTO mockedStudent = new StudentDTO(1L,"Facundo","", 0D,List.of(new SubjectDTO("History",10D)));
        StudentDTO expectedStudent = new StudentDTO(1L,"Facundo","El alumno Facundo ha obtenido un promedio de 10. Felicitaciones!", 10.00,List.of(new SubjectDTO("History",10D)));
        when(studentDAO.findById(1L)).thenReturn(mockedStudent);
        //Act
        StudentDTO obtainStudent = obtenerDiplomaService.analyzeScores(1L);
        //Assert
        assertThat(obtainStudent).usingRecursiveComparison().isEqualTo(expectedStudent);
    }
    @Test
    void analyzeScores_Ok_cheers(){
        //Arrange
        StudentDTO mockedStudent = new StudentDTO(1L,"Facundo","", 0D,List.of(new SubjectDTO("History",6D)));
        StudentDTO expectedStudent = new StudentDTO(1L,"Facundo","El alumno Facundo ha obtenido un promedio de 6. Puedes mejorar.", 6.00,List.of(new SubjectDTO("History",6D)));
        when(studentDAO.findById(1L)).thenReturn(mockedStudent);
        //Act
        StudentDTO obtainStudent = obtenerDiplomaService.analyzeScores(1L);
        //Assert
        assertThat(obtainStudent).usingRecursiveComparison().isEqualTo(expectedStudent);
    }
}
