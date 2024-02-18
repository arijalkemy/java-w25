package com.mercadolibre.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestEntradaDTO {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;
}
