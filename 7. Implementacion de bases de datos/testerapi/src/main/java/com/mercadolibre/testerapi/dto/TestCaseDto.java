package com.mercadolibre.testerapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TestCaseDto {
    private Long idCase;

    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private Integer numbreOfTries;
    @JsonProperty("last_update")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpdate;
}
