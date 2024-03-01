package com.bootcampW22.EjercicioGlobal.exampleTests;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.exception.ExceptionController;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HandlerTest {

    @Autowired
    ExceptionController exceptionController;

    @Test
    void NotFoundTestOk(){
        //ARRANGE
        NotFoundException e = new NotFoundException("mensaje");
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(new ExceptionDto("mensaje"),HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> response = exceptionController.notFound(e);
        //ASSERT
        assertEquals(expectedResponse, response);
    }
}
