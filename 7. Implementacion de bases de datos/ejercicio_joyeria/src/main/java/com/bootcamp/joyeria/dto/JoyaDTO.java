package com.bootcamp.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDTO {
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private boolean posee_piedra;
    @JsonProperty("venta_o_no")
    private boolean ventaONo;
}
