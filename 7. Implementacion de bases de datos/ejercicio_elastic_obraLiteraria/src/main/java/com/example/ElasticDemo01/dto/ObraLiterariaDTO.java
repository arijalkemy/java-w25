package com.example.ElasticDemo01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaDTO {
    String id;
    String nombre;
    String autor;
    Integer cantidadPaginas;
    String editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate fechaPublicacion;
}
