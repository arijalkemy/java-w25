package com.bootcamp.deportistas.dto;

import com.bootcamp.deportistas.entity.Persona;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class PersonaDeporteDTO {
    private String nombre;
    private String apellido;
    private List<String> nombreDeportes = new ArrayList<>();

    public PersonaDeporteDTO(Persona persona){
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        persona.getDeportes().forEach(deporte -> this.nombreDeportes.add(deporte.getNombre()));
    }
}
