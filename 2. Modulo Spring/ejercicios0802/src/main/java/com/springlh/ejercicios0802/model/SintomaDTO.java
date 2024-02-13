package com.springlh.ejercicios0802.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SintomaDTO {
    private String nombre;
    private String nivelDeGravedad;
}
