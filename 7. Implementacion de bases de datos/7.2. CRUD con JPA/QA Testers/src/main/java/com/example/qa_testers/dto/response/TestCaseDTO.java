package com.example.qa_testers.dto.response;

import java.time.LocalDate;
public record TestCaseDTO (
    Long idCase,
    String description,
    Boolean tested,
    Boolean passed,
    Integer numberOfTries,
    LocalDate lastUpdate
){}