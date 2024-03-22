package com.obrasliterarias.elasticsearch.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaDto {
    String nombre;
    String autor;
    Integer numPaginas;
    String editorial;
    Integer anioPublicacion;
}
