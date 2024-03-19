package com.QATesters.dto.response;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestCaseDto {
    @JsonProperty("id_case")
    private Long idCase;
    @JsonProperty("description")
    private String description;
    @JsonProperty("tested")
    private Boolean tested;
    @JsonProperty("passed")
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;
    @JsonProperty("last_update")
    private LocalDate lastUpdate;
}
