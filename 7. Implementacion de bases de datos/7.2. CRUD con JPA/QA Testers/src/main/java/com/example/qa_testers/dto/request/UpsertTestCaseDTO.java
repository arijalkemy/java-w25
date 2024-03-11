package com.example.qa_testers.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record UpsertTestCaseDTO (
    String description,
    @NotNull
    Boolean tested,
    @NotNull
    Boolean passed,
    @NotNull
    @PositiveOrZero
    Integer numberOfTries
){}