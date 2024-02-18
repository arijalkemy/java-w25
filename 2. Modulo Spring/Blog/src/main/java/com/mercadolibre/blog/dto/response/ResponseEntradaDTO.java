package com.mercadolibre.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseEntradaDTO {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;
}
