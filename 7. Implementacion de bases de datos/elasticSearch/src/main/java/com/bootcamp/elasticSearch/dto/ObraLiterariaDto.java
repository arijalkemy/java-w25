package com.bootcamp.elasticSearch.dto;

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
    int cantidadPaginas;
    String editorial;
    int anioPublicacion;
}
