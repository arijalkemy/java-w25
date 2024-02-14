package com.starWars.SpringMultiCapa.Controller.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonajeDTO {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}
