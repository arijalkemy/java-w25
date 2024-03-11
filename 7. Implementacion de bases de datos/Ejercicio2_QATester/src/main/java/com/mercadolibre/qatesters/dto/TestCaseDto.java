package com.mercadolibre.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadolibre.qatesters.entity.TestCase;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCaseDto {
    String description;
    Boolean tested;
    Boolean passed;
    int numberOfTries;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate lastUpdate;

    public TestCaseDto() {
    }

    public TestCaseDto(TestCase testCase) {
        this.description =  testCase.getDescription();
        this.tested = testCase.getTested();
        this.passed = testCase.getPassed();
        this.numberOfTries = testCase.getNumberOfTries();
        this.lastUpdate = testCase.getLastUpdate();
    }

    public TestCaseDto(String description, Boolean tested, Boolean passed, int numberOfTries, LocalDate lastUpdate) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }

}
