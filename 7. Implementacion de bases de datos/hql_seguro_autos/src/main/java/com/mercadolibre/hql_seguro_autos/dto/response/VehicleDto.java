package com.mercadolibre.hql_seguro_autos.dto.response;

import lombok.Data;

import java.util.List;
@Data
public class VehicleDto {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantidadRuedas;
    private List<SiniestroDto> siniestros;
}
