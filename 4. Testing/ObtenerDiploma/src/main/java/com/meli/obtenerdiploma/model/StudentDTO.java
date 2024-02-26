package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NonNull
    String studentName;
    String message;
    Double averageScore;
    @Valid
    List<SubjectDTO> subjects;
}
