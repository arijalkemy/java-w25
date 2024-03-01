package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static com.example.bootcampsprint1g6.util.DateFormatter.parseDateLocalDate;
import static com.example.bootcampsprint1g6.util.DateFormatter.parseDateString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DateFormatterTest {
    @Test
    @DisplayName("Parse to string - Ok")
    public void parseDateLocalDateOk(){

        // Arrange
        LocalDate date = LocalDate.of(2023, 5, 23);
        String expectedResult = "23-05-2023";

        // Act
        String result = parseDateLocalDate(date);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Parse from string - Ok")
    public void parseDateStringOk(){
        // Arrange
        String date = "23-05-2023";
        LocalDate expectedDate = LocalDate.of(2023, 5, 23);
        // Act
        LocalDate resultDate = parseDateString(date);
        // Assert
        assertEquals(expectedDate, resultDate);
    }

    @Test
    @DisplayName("Parse from string - Error String format")
    public void parseDateStringError(){
        // Arrange
        String date = "2345-45-67";
        // Act &  Assert
        assertThrows(BadRequestException.class, () -> DateFormatter.parseDateString(date));
    }
}
