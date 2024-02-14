package com.blog.ejercicio1.dto.response;

import java.util.Date;

import lombok.Data;
import com.blog.ejercicio1.entity.EntradaBlog;

@Data
public class EntradaBlogResponseDTO {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private Date fechaActual;

    public EntradaBlogResponseDTO(EntradaBlog entradaBlog) {
        this.id = entradaBlog.getId();
        this.titulo = entradaBlog.getTitulo();
        this.nombreAutor = entradaBlog.getNombreAutor();
        this.fechaActual = entradaBlog.getFechaActual();
    }
}
