package com.manejoExcepciones.blogAPI.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
