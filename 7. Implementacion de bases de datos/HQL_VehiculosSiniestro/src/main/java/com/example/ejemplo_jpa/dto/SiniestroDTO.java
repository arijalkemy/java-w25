package com.example.ejemplo_jpa.dto;

import com.example.ejemplo_jpa.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDTO {

    private Long idVehiculo;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;

}
