package com.bootcamp.ejercicio_concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private String date;
    private int kilometers;
    private String descriptions;
}
