package com.example.ejemplo_jpa.dto;

import com.example.ejemplo_jpa.model.SchoolSupply;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDtoResponse {
    private Long id;
    private String dni;
    private String name;
    private String lastname;
    @JsonAlias("professor_id")
    private ProfessorDto professor;
    @JsonAlias("professor_id")
    private SchoolSupply teacher;
}
