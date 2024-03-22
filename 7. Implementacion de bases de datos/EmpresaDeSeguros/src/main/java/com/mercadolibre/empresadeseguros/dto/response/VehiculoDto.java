package com.mercadolibre.empresadeseguros.dto.response;

public record VehiculoDto(
        Integer idVehiculo,
         String patente,
         String marca,
         String modelo,
         Integer anioDeFabricacion,
         Integer cantidadDeRuedas
) {

}
