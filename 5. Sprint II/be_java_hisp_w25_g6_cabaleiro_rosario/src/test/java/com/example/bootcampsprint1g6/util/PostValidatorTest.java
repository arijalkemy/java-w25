package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.example.bootcampsprint1g6.util.builder.Mockbuilder.buildPostRequestDTO;
import static com.example.bootcampsprint1g6.util.validator.PostValidator.validateRequestDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class PostValidatorTest {
    @Test
    @DisplayName("Post request validator - Ok")
    public void validateRequestDTOOk() {
        // Arrange
        PostRequestDTO request = buildPostRequestDTO("23-05-2023", 1);
        Boolean expectedResult = true;

        // Act
        Boolean result = validateRequestDTO(request);

        // Assert
        assertEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Post request validator - Future Date error")
    public void validateRequestDTOfutureDateError() {
        // Arrange
        PostRequestDTO request = buildPostRequestDTO("23-05-2033", 1);
        Boolean expectedResult = false;

        // Act
        Boolean result = validateRequestDTO(request);

        // Assert
        assertEquals(expectedResult, result);
    }
}
