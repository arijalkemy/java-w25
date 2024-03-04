package com.mercadolibre.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseIdMensajeDTO {
    private int id;
    private String mensaje;
}
