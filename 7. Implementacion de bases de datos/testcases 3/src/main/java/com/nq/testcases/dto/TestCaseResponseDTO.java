package com.nq.testcases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TestCaseResponseDTO(
        String description,

        Boolean tested,

        Boolean passed,

        @JsonProperty("number_of_tries")
        Integer numberOfTries
) {
}
