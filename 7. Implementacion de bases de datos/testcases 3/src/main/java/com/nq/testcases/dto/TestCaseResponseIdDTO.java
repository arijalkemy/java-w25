package com.nq.testcases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record TestCaseResponseIdDTO(
        Long id,
        String description,

        Boolean tested,

        Boolean passed,

        @JsonProperty("number_of_tries")
        Integer numberOfTries,
        LocalDate lastUpdate
) {
}
