package com.ValentinCampestri.ObrasLiterarias.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ObraLiterariaDto {
    //id, el nombre, autor, cantidad de páginas, editorial y el año de su primera publicación.
    String nombre;
    String autor;
    Integer cantidadDePaginas;
    String editorial;
    Integer anioPrimerPublicacion;
}
