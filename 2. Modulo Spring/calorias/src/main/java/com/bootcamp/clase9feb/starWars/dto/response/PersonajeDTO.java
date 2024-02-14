package com.bootcamp.clase9feb.starWars.dto.response;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

// No tiene setters
public record PersonajeDTO (
        String name,
        Integer height,
        Integer mass,
        String gender,
        String homeworld,
        String species) {

}
