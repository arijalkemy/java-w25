package com.ValentinCampestri.ObrasLiterarias.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ObraLiteraria")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ObraLiteraria {
    //id, el nombre, autor, cantidad de páginas, editorial y el año de su primera publicación.
    @Id
    String id;
    String nombre;
    String autor;
    int cantidadDePaginas;
    String editorial;
    int anioPrimerPublicacion;

    public ObraLiteraria(String nombre, String autor, int cantidadDePaginas, String editorial, int anioPrimerPublicacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadDePaginas = cantidadDePaginas;
        this.editorial = editorial;
        this.anioPrimerPublicacion = anioPrimerPublicacion;
    }
}
