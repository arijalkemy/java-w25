package com.bootcamp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ReqTestCaseDto {

    @JsonProperty("description")
    String description;
    @JsonProperty("tested")
    Boolean tested;
    @JsonProperty("passed")
    Boolean passed;
    @JsonProperty("number_of_tries")
    Integer numberOfTries;
    @JsonProperty("last_update")
    LocalDate lastUpdate;

}