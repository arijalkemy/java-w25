package com.mercadolibre.empresadeseguros.dto.request;

import java.time.LocalDate;

public record CreateSiniestroDto (
        LocalDate fechaDeSiniestro,
        Double perdidaEconomica,
        Long idVehiculo
){
}
