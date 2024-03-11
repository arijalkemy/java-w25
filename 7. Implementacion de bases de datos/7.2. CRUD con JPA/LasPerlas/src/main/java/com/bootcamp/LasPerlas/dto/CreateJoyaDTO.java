package com.bootcamp.LasPerlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJoyaDTO {
    private Long nro_id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private boolean posee_piedra;
}