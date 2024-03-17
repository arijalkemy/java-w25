package com.obrasliterarias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObraDTO {

    String id;
    String nombre;
    String autor;
    Integer paginas;
    String editorial;
    Integer anio;
}
