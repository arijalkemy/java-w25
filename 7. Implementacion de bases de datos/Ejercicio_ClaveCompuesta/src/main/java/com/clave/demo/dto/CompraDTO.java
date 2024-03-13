package com.clave.demo.dto;

import com.clave.demo.model.CompraKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class CompraDTO {
    private Long clienteId;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    private String descripcion;
}
