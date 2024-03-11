package com.implementacionbasedatos.ejercicio1.dto.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JewerlyReqDto {

    @JsonProperty("nro_Identificatorio")
    private Long nroIdentificatorio;

    private String nombre;

    private String material;

    @JsonProperty("peso")
    private Double pesoGramos;

    private String particularidad;

    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;

    private Boolean ventaONo;
}
