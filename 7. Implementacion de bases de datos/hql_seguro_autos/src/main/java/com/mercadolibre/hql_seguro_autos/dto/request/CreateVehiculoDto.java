package com.mercadolibre.hql_seguro_autos.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data

public class CreateVehiculoDto {
    private String patente;
    private String marca;
    private String modelo;
    @JsonProperty("anio_fabricacion")
    private Integer anioFabricacion;
    @JsonProperty("cantidad_ruedas")
    private Integer cantidadRuedas;
    private List<CreateSiniestroDto> siniestros;
}
