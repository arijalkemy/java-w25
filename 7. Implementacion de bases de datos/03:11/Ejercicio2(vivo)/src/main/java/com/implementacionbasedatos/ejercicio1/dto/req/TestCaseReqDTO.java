package com.implementacionbasedatos.ejercicio1.dto.req;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestCaseReqDTO {
    @JsonProperty("id_case")
    private Long idCase;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("last_update")
    private LocalDate lastUpdate;
}
