package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepositorywri;
    @InjectMocks
    StudentService studentService;

    @Test
    void createTest(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));
        StudentDTO studentDTO = new StudentDTO(1L, "Pedro", "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" , 4.30, subjectDTOList);

        //doNothing().when(studentDAO).save(any(StudentDTO.class));
        //ACT y ASSERT
        studentService.create(studentDTO);

        //verify(studentService,atLeast(1)).create(any());
        verify(studentDAO,atLeast(1)).save(any());
        //verify(nombreDeServicio, atLeats(1)).nombreDelMetodo();

    }
    @Test
    void readTest(){
        //ARRANGE
        List<SubjectDTO> subjectDTOList = new ArrayList<>(Arrays.asList(
                new SubjectDTO("Calculo",4.30),
                new SubjectDTO("Ingles",4.30)
        ));
        StudentDTO studentDTOExp = new StudentDTO(1L, "Pedro", "El alumno Pedro ha obtenido un promedio de 4.30. Felicitaciones!" , 4.30, subjectDTOList);
        StudentDTO studentDTORes;
        when(studentService.read(anyLong())).thenReturn(studentDTOExp);

        //ACT
        studentDTORes = studentService.read(anyLong());

        //ASSERT
        assertEquals(studentDTOExp,studentDTORes);

    }
    @Test
    void updateTest(){
        //ARRANGE
        StudentDTO studentDTOExp = studentService.read(1L);
        StudentDTO studentDTORes;

        //doNothing().when(studentService).update(any());
        doNothing().when(studentDAO).save(any());

        //ACT
        studentService.update(any());

        //ASSERT
        verify(studentDAO,atLeast(1)).save(any());
    }
    @Test
    void deleteTest(){
        //ARRANGE
        //doNothing().when(studentService).delete(anyLong());
        when(studentDAO.delete(anyLong())).thenReturn(true);

        //ACT
        studentService.delete(anyLong());

        //ASSERT
        verify(studentDAO,atLeast(1)).delete(anyLong());
    }
    @Test
    void getAllTest(){
        //ARRANGE
        //Set
        when(studentDAO.delete(anyLong())).thenReturn(true);

        //ACT
        studentService.delete(anyLong());

        //ASSERT
        verify(studentDAO,atLeast(1)).delete(anyLong());
    }

}
