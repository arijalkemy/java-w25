package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.factory.TestFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;
    StudentDTO student;
    long id;

    @BeforeEach
    public void before(){
        student = TestFactory.createStudentDTO();
        id = 1L;
    }

    //Validar un correcto funcionamiento
    @Test
    public void getGreetingMessageMayBeReturnAStuObjectOk(){
        //ARRANGE
        long id = 1;
        when(studentDAO.findById(id)).thenReturn(student);
        //ACT
        StudentDTO obtains = obtenerDiplomaService.analyzeScores(id);
        verify(studentDAO,atLeast(1)).findById(id);
        //ASSERT
        //Obtiene el mensaje
        assertEquals("El alumno Julio ha obtenido un promedio de 10. Felicitaciones!",obtains.getMessage());
        //El promedio esta bien
        assertEquals(10.0, obtains.getAverageScore());
    }

}
