package com.manejoExcepciones.blogAPI.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogResponseDTO {

    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
