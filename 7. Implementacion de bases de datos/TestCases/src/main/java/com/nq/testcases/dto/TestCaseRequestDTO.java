package com.nq.testcases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseRequestDTO{
        private String description;
        private Boolean tested;
        private Boolean passed;
        @JsonProperty("number_of_tries")
        private Integer numberOfTries;
}
