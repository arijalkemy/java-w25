package com.example.ElasticDemo01.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaFiltrosDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate fecha;
    String palabraClave;
    String autor;
    String editorial;
}
