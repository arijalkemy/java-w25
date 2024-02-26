package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {
    String name;
    @Size(min = 0,max = 100)
    Double score;
}
