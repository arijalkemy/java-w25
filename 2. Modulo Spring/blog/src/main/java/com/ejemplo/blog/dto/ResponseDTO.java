package com.ejemplo.blog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    private Integer id;
    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;
    private Integer status;

    public ResponseDTO(Integer id) {
        this.id = id;
    }
}
