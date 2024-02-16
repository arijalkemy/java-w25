package com.ejemplo.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EntradaBlog {

    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;
}
