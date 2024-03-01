package com.example.bootcampsprint1g6.exception;

import com.example.bootcampsprint1g6.dto.GenericResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionControllerTest {
    @Autowired
    ExceptionController exceptionController;
    @Test
    @DisplayName("Test MethodArgumentTypeMismatchException Handling")
    void handleMethodArgumentTypeMismatchException(){
        MethodArgumentTypeMismatchException exception = new MethodArgumentTypeMismatchException(null,null,null,null,null);
        ResponseEntity<GenericResponseDTO> responseEntity = exceptionController.methodArgumentTypeMismatch(exception);

        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
        assertEquals("Error en el tipo de datos de los parámetros",responseEntity.getBody().getMessage());
    }

    @Test
    @DisplayName("Test IllegalArgumentException Handling")
    void handleIllegalArgumentException(){
        IllegalArgumentException exception = new IllegalArgumentException("Illegal Argument Exception");
        ResponseEntity<GenericResponseDTO> responseEntity = exceptionController.illegalArgument(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Illegal Argument Exception",responseEntity.getBody().getMessage());
    }

    @Test
    @DisplayName("Test NullPointerException Handling")
    void handleNullPointerException(){
        NullPointerException exception = new NullPointerException("Null Pointer Exception");
        ResponseEntity<GenericResponseDTO> responseEntity = exceptionController.nullPointerException(exception);

        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
        assertEquals("Atributos faltantes, por favor verifique la información enviada.",responseEntity.getBody().getMessage());
    }

    @Test
    @DisplayName("Test HttpMessageNotReadableException Handling")
    void handleHttpMessageNotReadableException(){
        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("Error en el tipo de datos enviados");
        ResponseEntity<GenericResponseDTO> responseEntity = exceptionController.illegalArgument(exception);

        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
        assertEquals("Error en el tipo de datos enviados",responseEntity.getBody().getMessage());
    }

    @Test
    @DisplayName("Test NoResourceFoundException Handling")
    void handleNoResourceFoundException(){
        NoResourceFoundException exception = new NoResourceFoundException(HttpMethod.POST,"api/example");
        ResponseEntity<GenericResponseDTO> responseEntity = exceptionController.resourceNotFound(exception);

        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
        assertEquals("Endpoint inexistente",responseEntity.getBody().getMessage());
    }

    @Test
    @DisplayName("Test HttpRequestMethodNotSupportedException Handling")
    void handleHttpRequestMethodNotSupportedException(){
        HttpRequestMethodNotSupportedException exception = new HttpRequestMethodNotSupportedException("Http Request Method Not Supported Exception");
        ResponseEntity<GenericResponseDTO> responseEntity = exceptionController.httpRequestMethodNotSupported(exception);

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED,responseEntity.getStatusCode());
        assertEquals("Metodo no soportado",responseEntity.getBody().getMessage());
    }

    @Test
    @DisplayName("Test MethodArgumentNotValid Exception Handling")
    void handleMethodArgumentNotValidException() {
        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, createBindingResult());
        ResponseEntity<GenericResponseDTO> responseEntity = exceptionController.methodArgumentNotValid(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Error message", responseEntity.getBody().getMessage());
    }

    private BindingResult createBindingResult() {
        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(new FieldError("objectName", "fieldName", "Error message"));
        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.getFieldError()).thenReturn(fieldErrors.get(0));
        return bindingResult;
    }
}
