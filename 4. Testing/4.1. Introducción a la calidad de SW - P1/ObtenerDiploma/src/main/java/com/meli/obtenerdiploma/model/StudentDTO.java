package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<@Valid SubjectDTO> subjects;
}
