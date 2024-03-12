package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede ser vacío.")
    @NotNull(message = "El nombre del alumno no puede ser nulo.")
    String studentName;
    @NotNull(message = "El mensaje no puede ser nulo.")
    @Size(min = 10, max = 200, message = "El mensaje debe tener entre 10 y 200 caracteres.")
    String message;

    @NotNull(message = "La puntuación promedio no puede ser nula.")
    @Min(value = 0, message = "La puntuación promedio no puede ser menor que 0.")
    @Max(value = 10, message = "La puntuación promedio no puede ser mayor que 10.")
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<SubjectDTO> subjects;
}
