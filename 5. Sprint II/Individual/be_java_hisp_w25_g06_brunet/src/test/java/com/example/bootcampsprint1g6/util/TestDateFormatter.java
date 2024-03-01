package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TestDateFormatter {
    @Test
    @DisplayName("Test ParseException in parseDateString method")
    void testParseExceptionInParseDateString(){
        String invalidDateString = "2024-02-30";

        BadRequestException exception = assertThrows(BadRequestException.class,()->{
            DateFormatter.parseDateString(invalidDateString);
        });

        assertEquals("Tipo fecha incorrecta",exception.getMessage());
    }
}
