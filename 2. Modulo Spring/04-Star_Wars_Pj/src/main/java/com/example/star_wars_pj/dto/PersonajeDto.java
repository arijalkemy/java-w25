package com.example.star_wars_pj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class PersonajeDto {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;


}
