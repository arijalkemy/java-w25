package com.manejoExcepciones.blogAPI.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogRequestDTO {

    private Integer id;
    private String titulo;
    private String nombreAutor;
}
