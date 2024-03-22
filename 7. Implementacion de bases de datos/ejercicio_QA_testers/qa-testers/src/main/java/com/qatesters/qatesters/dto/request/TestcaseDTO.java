package com.qatesters.qatesters.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TestcaseDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer numberOfTries;
    @JsonFormat(pattern = "dd/MM/yyy")
    private LocalDate lastUpdated;
}
