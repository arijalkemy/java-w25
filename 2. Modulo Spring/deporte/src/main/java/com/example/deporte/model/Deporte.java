package com.example.deporte.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Deporte {
    private String nombre;
    private int nivel;
}
