package com.ejemplo.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionDTO {

    private String message;
    private String description;
    private Integer status;
}
