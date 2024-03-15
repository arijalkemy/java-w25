package com.example.showroom.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClotheReqDto {
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    Double precio;
}
