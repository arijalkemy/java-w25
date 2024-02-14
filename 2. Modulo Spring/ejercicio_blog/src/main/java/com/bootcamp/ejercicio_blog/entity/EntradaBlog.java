package com.bootcamp.ejercicio_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private Date fechaPublicacion;
}
