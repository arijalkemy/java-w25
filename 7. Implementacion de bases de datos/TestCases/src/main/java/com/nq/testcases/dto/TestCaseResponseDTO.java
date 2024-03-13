package com.nq.testcases.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseResponseDTO{
        private String description;
        private Boolean tested;
        private Boolean passed;
        @JsonProperty("number_of_tries")
        private Integer numberOfTries;
        @JsonProperty("last_update")
        private LocalDate lastUpdate;
}
