package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaExceptionController;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.ErrorDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaExceptionControllerTest {

    @Mock
    ObtenerDiplomaException exception;

    @InjectMocks
    ObtenerDiplomaExceptionController controller;

    @Test
    void testObtenerDiplomaExceptionController() {
        // arrange
        String message = "message";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorDTO errorDTO = new ErrorDTO("code", message);
        when(exception.getError()).thenReturn(errorDTO);
        when(exception.getStatus()).thenReturn(status);

        // act
        ResponseEntity<ErrorDTO> response = controller.handleGlobalExceptions(exception);

        // assert
        assertEquals(status, response.getStatusCode());
        assertEquals(errorDTO, response.getBody());
    }

    @Test
    void testHandleValidationExceptionsMethodArgumentNotValid() {
        // arrange
        String defaultMessage = "default message";
        FieldError fieldError = new FieldError("objectName", "field", defaultMessage);
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getFieldError()).thenReturn(fieldError);
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);

        // act
        ResponseEntity<ErrorDTO> response = controller.handleValidationExceptions(exception);

        // assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("MethodArgumentNotValidException", response.getBody().getName());
        assertEquals(defaultMessage, response.getBody().getDescription());
    }

    @Test
    void testHandleValidationExceptionsHttpMessageNotReadable() {
        // arrange
        String message = "message";
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException(message);

        // act
        ResponseEntity<ErrorDTO> response = controller.handleValidationExceptions(exception);

        // assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("HttpMessageNotReadableException", response.getBody().getName());
        assertEquals(message, response.getBody().getDescription());
    }
}