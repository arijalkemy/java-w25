package com.consultashql.DTO;

import com.consultashql.model.Vehiculo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroDTO {
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
    private Double perdida_economica;
    private Long vehiculo_denunciado;
}
