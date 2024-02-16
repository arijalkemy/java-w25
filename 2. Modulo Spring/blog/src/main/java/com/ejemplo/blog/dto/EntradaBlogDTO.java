package com.ejemplo.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EntradaBlogDTO {

    private Integer id;
    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;
}
