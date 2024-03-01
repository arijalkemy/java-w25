package org.socialmeli.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.socialmeli.dto.response.ExceptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GlobalExceptionHandlerTest {
    @Autowired
    GlobalExceptionHandler globalExceptionHandler;

    @Test
    @DisplayName("[COV-0008] Bad Request Exception Handler Ok")
    void badRequestOkTest() {
        //ARRANGE
        BadRequestException e = new BadRequestException("Test message");
        ResponseEntity<?> expected = new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.BAD_REQUEST);
        //ACT
        ResponseEntity<?> response = globalExceptionHandler.badRequest(e);
        //ASSERT
        assertEquals(expected, response);
    }

    @Test
    @DisplayName("[COV-0008] Not Found Exception Handler Ok")
    void notFoundOkTest() {
        //ARRANGE
        NotFoundException e = new NotFoundException("Test message");
        ResponseEntity<?> expected = new ResponseEntity<>(new ExceptionDto(e.getMessage()), HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> response = globalExceptionHandler.notFound(e);
        //ASSERT
        assertEquals(expected, response);
    }
}
