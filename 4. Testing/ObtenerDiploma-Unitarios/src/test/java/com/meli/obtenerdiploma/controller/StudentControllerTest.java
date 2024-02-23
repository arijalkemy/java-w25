package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTest {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentTest(){

    }

    @Test
    public void getStudentTest(){

    }

    @Test
    public void modifyStudentTest(){

    }

    @Test
    public void removeStudentTest(){

    }

    @Test
    public void getAllStudentTest(){

    }


}
