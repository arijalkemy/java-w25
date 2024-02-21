package com.spring.deporte.mapper;


import com.spring.deporte.domain.Persona;
import com.spring.deporte.dto.PersonaDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonaMapper {
    public static PersonaDTO getInstance(Persona persona) {
        PersonaDTO dto = PersonaDTO.builder()
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .edad(persona.getEdad())
                .build();
        Optional.ofNullable(persona.getDeportes()).ifPresent(deportes -> {
            dto.setDeportes(DeporteMapper.getInstances(deportes));
        });
        return dto;
    }

    public static List<PersonaDTO> getInstances(List<Persona> personas) {
        return personas.stream().map(PersonaMapper::getInstance).collect(Collectors.toList());
    }
}
