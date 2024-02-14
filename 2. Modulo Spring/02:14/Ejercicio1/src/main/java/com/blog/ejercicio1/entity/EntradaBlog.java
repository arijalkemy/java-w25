package com.blog.ejercicio1.entity;

import java.util.Date;

import lombok.Data;

@Data
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private Date fechaActual;
    private static Integer contador = 0;

    public EntradaBlog(String titulo, String nombreAutor) {
        this.id = ++EntradaBlog.contador;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaActual = new Date();
    }

}
