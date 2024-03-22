package com.mercadolibre.empresadeseguros.dto.response;

import java.time.LocalDate;

public record SiniestroDto (
        Long idSiniestro,
        LocalDate fechaDeSiniestro,
        Double perdidaEconomica
) {
}
