package com.example.deportes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonaDto {

    private String nombre;

    private String apellido;

    private List<String> nombreDeporte;
}
