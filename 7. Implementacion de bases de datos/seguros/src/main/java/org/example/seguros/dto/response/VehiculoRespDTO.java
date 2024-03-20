package org.example.seguros.dto.response;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import org.example.seguros.entity.Siniestro;

import java.util.List;

public record VehiculoRespDTO(
        Long id,
        String patente,
        String marca,
        String modelo,
        Integer anioFabricacion,
        Integer cantidadRuedas,
        List<Siniestro> siniestroList
) {
}
