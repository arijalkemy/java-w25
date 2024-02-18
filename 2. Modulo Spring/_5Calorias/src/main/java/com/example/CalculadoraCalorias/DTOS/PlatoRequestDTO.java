package com.example.CalculadoraCalorias.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoRequestDTO {
    private String name;
    private HashMap<String,String> ingredientsPlate;
}
