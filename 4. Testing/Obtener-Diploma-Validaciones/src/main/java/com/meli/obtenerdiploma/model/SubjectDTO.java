package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "Se debe proporcionar un nombre de materia")
    String name;
    @NotNull(message = "Se debe proporcionar un puntaje de materia")
    @Min(value = 1, message = "El puntaje debe ser al menos 1")
    @Max(value = 10, message = "El puntaje debe ser como máximo 10")
    Double score;
}
