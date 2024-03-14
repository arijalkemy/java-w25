package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void createOk(){
        //Arrange
        StudentDTO studentDto = new StudentDTO(1L, "Juan", null, 0.0, new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        )));
        doNothing().when(studentDAO.save(studentDto));
        //Act Assert
        verify(studentDAO, atLeast(1)).save(studentDto);



    }

    @Test
    void readOk(){

    }

    @Test
    void deleteOk(){

    }

    @Test
    void getAllOk(){

    }

}