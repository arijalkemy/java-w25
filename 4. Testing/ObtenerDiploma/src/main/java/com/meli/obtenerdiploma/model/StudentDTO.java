package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotNull(message="StudentName is required")
    String studentName;
    @NotNull(message="Message is required")
    String message;
    @Size(min=0,max=100,message = "AverageScore value beetween 0 and 100")
    Double averageScore;
    @NotNull(message="Subjects is required")
    List<@Valid SubjectDTO> subjects;
}
