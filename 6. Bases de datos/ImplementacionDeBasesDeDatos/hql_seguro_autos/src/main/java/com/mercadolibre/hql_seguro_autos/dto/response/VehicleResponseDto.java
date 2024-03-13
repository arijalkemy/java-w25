package com.mercadolibre.hql_seguro_autos.dto.response;

import lombok.Data;

import java.util.List;
@Data
public class VehicleResponseDto {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantidadRuedas;
    private List<SiniestroResponseDto> siniestros;
}
