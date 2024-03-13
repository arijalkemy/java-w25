package com.example.ejemplo_jpa.dto;

import com.example.ejemplo_jpa.model.Siniestro;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculoDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioDeFabricacion;
    private Integer cantidadDeRuedas;
}
