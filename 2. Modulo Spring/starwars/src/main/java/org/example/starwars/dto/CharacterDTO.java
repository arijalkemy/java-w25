package org.example.starwars.dto;

public record CharacterDTO(
        String name,
        double height,
        double mass,
        String gender,
        String homeworld,
        String species
) {}
