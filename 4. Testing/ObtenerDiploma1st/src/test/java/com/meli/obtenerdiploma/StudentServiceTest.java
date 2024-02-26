package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("0001| create test")
    void studentCreateTest(){
        //ARRANGE
        StudentDTO student = new StudentDTO(12L,"name",null,null, List.of());
        //ACT
        studentService.create(student);
        //ASSERT
        verify(studentDAO).save(student);
    }

    @Test
    @DisplayName("0002| get test")
    void studentGetOneTest(){
        //ARRANGE
        long id = 1L;
        StudentDTO studentExpected = new StudentDTO(1L,"Pedro",null,null, List.of(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",  7.0),
                new SubjectDTO("Química",  6.0)
        ));
        when(studentDAO.findById(id)).thenReturn(studentExpected);
        //ACT
        StudentDTO studentObtained = studentService.read(id);
        //ASSERT
        assertEquals(studentExpected,studentObtained);
        verify(studentDAO).findById(id);
    }
}
