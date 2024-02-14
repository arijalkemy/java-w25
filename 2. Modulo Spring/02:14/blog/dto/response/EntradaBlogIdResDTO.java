package com.blog.ejercicio1.dto.response;

import com.blog.ejercicio1.entity.EntradaBlog;

import lombok.Data;

@Data
public class EntradaBlogIdResDTO {
    private Integer id;

    public EntradaBlogIdResDTO(EntradaBlog entradaBlog) {
        this.id = entradaBlog.getId();
    }
}
