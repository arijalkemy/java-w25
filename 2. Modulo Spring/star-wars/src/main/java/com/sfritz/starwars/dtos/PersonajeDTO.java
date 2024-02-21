package com.sfritz.starwars.dtos;

//No tiene seters, toca construirlo directamente al objeto.
public record PersonajeDTO(
    String name,
    Integer height,
    Integer mass,
    String gender,
    String homeworld,
    String species) {}
