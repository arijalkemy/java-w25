package com.example.showroom.dto.response;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
public class ClotheDto {
    Long codigo;
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    Double precio;
}
