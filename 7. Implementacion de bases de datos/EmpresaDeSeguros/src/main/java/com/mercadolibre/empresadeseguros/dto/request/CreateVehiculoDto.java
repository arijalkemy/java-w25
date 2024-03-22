package com.mercadolibre.empresadeseguros.dto.request;

public record CreateVehiculoDto (
        String patente,
        String marca,
        String modelo,
        Integer anioDeFabricacion,
        Integer cantidadDeRuedas
){
}
