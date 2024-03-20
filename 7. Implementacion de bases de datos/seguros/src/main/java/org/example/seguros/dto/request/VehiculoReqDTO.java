package org.example.seguros.dto.request;

import org.example.seguros.entity.Siniestro;

import java.util.List;

public record VehiculoReqDTO(
        String patente,
        String marca,
        String modelo,
        Integer anioFabricacion,
        Integer cantidadRuedas,
        List<Siniestro> siniestroList
) {
}
