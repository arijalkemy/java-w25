package com.example.youtuber.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {
    private int idBlog;
    private String tituloDelBlog;
    private String nombreDelAutor;
    private String fechaDePublicacion;
}
