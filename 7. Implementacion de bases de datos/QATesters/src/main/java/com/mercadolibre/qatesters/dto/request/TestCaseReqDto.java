package com.mercadolibre.qatesters.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCaseReqDto {
    String description;
    Boolean tested;
    Boolean passed;
    int numberOfTries;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate lastUpdate;

    public TestCaseReqDto() {
    }

    public TestCaseReqDto(String description, Boolean tested, Boolean passed, int numberOfTries, LocalDate lastUpdate) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }

}
