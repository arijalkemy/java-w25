package com.bootcamp.ejercicio_blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseEntradaBlogDTO {
    private int id;
    private String mensaje;
}
