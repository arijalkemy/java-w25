package com.example.bootcampsprint1g6.util;

import com.example.bootcampsprint1g6.exception.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class DateFormatterTest {

    @Test
    @DisplayName("Parse date string - Success")
    public void parseDateStringTestOk() {
        //Arrange
        String dateToParse = "20-02-2024";
        String expectedDate = "2024-02-20";

        //Act
        LocalDate date = DateFormatter.parseDateString(dateToParse);

        //Assert
        assertThat(date.toString()).isEqualTo(expectedDate);
    }

    @Test
    @DisplayName("Parse date string - Invalid format")
    public void parseDateStringTestInvalidFormat() {
        //Arrange
        String dateToParse = "invalid date format";

        //Act & Assert
        assertThrows(BadRequestException.class, () -> DateFormatter.parseDateString(dateToParse));
    }

    @Test
    @DisplayName("Parse local date - Success")
    public void parseDateLocalDateTestOk() {
        //Arrange
        LocalDate dateToParse = LocalDate.of(2024, 2, 20);
        String expectedDate = "20-02-2024";

        //Act
        String date = DateFormatter.parseDateLocalDate(dateToParse);

        //Assert
        assertThat(date).isEqualTo(expectedDate);
    }

}
