package com.meli.obtenerdiploma.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaExceptionControllerTest {

    @InjectMocks
    ObtenerDiplomaExceptionController obtenerDiplomaExceptionController;

    @Test
    public void obtenerDiplomaExceptionCorrect() throws Exception{

    }

}
