package com.bootcamp.ejercicio_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EntradaBlogDTO {
    private int id;
    private String titulo, nombreAutor, fecha;
}
