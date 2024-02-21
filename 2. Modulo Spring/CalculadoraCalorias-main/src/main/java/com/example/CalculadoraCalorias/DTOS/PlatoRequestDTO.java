package com.example.CalculadoraCalorias.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoRequestDTO {
    private String name;
    private int weight;
}
