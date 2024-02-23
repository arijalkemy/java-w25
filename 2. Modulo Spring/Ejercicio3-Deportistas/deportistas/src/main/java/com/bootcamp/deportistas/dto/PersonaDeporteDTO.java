package com.bootcamp.deportistas.dto;

import com.bootcamp.deportistas.entity.Deporte;
import com.bootcamp.deportistas.entity.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
public class PersonaDeporteDTO {
    private String nombreCompleto;
    private List<String> deportes;

}
