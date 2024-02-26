package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SubjectDTO {
    @NotNull
    String name;
    @NotNull
    @Min(1)
    @Max(10)
    Double score;
}
