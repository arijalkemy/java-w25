package com.implementacionbasedatos.ejercicio1.dto.res;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCaseResDTO {
    @JsonProperty("id_case")
    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    private LocalDate lastUpdate;
}
