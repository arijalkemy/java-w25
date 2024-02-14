package com.blog.ejercicio1.dto.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlogRequestDTO {
    private String titulo;
    private String nombreAutor;
    private Date fechaActual;
}
