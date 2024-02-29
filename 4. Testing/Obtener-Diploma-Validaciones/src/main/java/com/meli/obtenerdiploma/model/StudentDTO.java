package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "Se debe proporcionar un nombre de estudiante")
    String studentName;
    String message;
    Double averageScore;
    List<@Valid SubjectDTO> subjects;
}
