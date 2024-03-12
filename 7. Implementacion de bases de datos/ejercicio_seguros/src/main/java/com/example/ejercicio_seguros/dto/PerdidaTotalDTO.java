package com.example.ejercicio_seguros.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PerdidaTotalDTO {
        String patente;
        String marca;
        String modelo;
        double perdidaTotal;
}