package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    String name;
    @Min(value = 0, message = "La calificación no puede ser menor a 0.")
    @Max(value = 10, message = "La calificación no puede ser mayor a 10.")
    Double score;
}
