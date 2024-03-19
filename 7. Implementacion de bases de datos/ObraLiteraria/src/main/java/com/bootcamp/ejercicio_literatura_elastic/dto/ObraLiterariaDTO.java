package com.bootcamp.ejercicio_literatura_elastic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaDTO {
    String nombre;
    String autor;
    Integer cantidadPaginas;
    String editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate anioPublicacion;
}
