package com.obrasliterarias.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObraDTO {
    String nombre;
    String autor;
    Integer paginas;
    String editorial;
    Integer anio;
}
