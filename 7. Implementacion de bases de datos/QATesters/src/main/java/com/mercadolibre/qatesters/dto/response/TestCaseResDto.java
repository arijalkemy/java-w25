package com.mercadolibre.qatesters.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCaseResDto {
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    int numberOfTries;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate lastUpdate;

    public TestCaseResDto() {
    }

    public TestCaseResDto(Long id, String description, Boolean tested, Boolean passed, int numberOfTries, LocalDate lastUpdate) {
        this.id = id;
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }
}
