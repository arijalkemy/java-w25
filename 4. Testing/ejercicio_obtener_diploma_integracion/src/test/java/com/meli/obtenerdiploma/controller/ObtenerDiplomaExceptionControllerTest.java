package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ObtenerDiplomaExceptionControllerTest {
    private final ObtenerDiplomaExceptionController obtenerDiplomaExceptionController;
    public ObtenerDiplomaExceptionControllerTest(){
        this.obtenerDiplomaExceptionController = new ObtenerDiplomaExceptionController();

    }
    @Test
    void handleGlobalExceptions() {
        ResponseEntity<?> expectedResponse = new ResponseEntity<>(new ErrorDTO(ObtenerDiplomaException.class.getSimpleName(), "Error!"), HttpStatus.BAD_REQUEST);
        ObtenerDiplomaException obtenerDiplomaException = new ObtenerDiplomaException("Error!", HttpStatus.BAD_REQUEST);
        ResponseEntity<?> actualResponse = this.obtenerDiplomaExceptionController.handleGlobalExceptions(obtenerDiplomaException);
        assertEquals(expectedResponse, actualResponse);
    }

}