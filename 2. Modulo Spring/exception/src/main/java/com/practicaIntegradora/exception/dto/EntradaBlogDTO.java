package com.practicaIntegradora.exception.dto;

import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntradaBlogDTO {

    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
