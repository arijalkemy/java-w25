package com.practica.elastic.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObrasDTO {

    private String name;
    private String autor;
    private Integer numeroPaginas;
    private String editorial;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicacion;
}
