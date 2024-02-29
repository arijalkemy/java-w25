package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
public class SubjectDTO {
    @NotNull(message="Subject name is required")
    String name;

    @PositiveOrZero(message = "Score is positive")
    @Max(value=100, message = "Score max value is 100")
    Double score;
}
