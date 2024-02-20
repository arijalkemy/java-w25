package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class EntradaBlog {
    private long id;
    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;
}
