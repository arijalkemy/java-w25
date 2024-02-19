package com.springboot.ejerciciodeportista.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deporte {
    private String nombre;
    private String nivel;
}
