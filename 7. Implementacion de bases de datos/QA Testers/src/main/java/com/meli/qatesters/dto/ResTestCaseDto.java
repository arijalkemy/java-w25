package com.meli.qatesters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResTestCaseDto {
    @JsonProperty("id_case")
    Long idCase;
    String description;
    Boolean tested;
    Boolean passed;
    @JsonProperty("number_of_tries")
    int numberOfTries;
    @JsonProperty("last_update")
    LocalDate lastUpdate;
}
