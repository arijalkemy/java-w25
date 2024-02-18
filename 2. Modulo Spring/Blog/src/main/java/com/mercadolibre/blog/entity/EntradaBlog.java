package com.mercadolibre.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;
}
