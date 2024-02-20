package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class EntradaBlogDTO {
    private Integer id;
    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;

    public EntradaBlogDTO(int id, String tituloBlog, String nombreAutor, String fechaPublicacion) {
        this.id = id;
        this.tituloBlog = tituloBlog;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloBlog() {
        return tituloBlog;
    }

    public void setTituloBlog(String tituloBlog) {
        this.tituloBlog = tituloBlog;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}


