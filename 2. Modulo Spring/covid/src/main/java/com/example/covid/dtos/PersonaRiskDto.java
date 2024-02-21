package com.example.covid.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonaRiskDto {
    private String name;

    private String apellido;

    private List<String> sintomas;
}
