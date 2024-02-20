package com.example.exceptions.dto;


import com.example.exceptions.entity.EntradaBlog;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BlogDto {
     String titulo;
     String nombreAutor;
     LocalDate fechaPublicacion;

    public BlogDto(EntradaBlog entradaBlog){
        this.titulo =entradaBlog.getTitulo();
        this.nombreAutor = entradaBlog.getAutor();
        this.fechaPublicacion = entradaBlog.getFechaPublicacion();
    }
}
