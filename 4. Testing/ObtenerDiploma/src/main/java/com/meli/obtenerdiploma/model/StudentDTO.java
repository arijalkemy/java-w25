package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank
    String studentName;
    @NotBlank
    String message;
    @Min(30) @Max(115) @Positive
    Double averageScore;
    @NotNull
    List<SubjectDTO> subjects;
}
