package com.mercadolibre.hql_seguro_autos.service;

import com.mercadolibre.hql_seguro_autos.dto.request.CreateVehiculoDto;
import com.mercadolibre.hql_seguro_autos.dto.response.PatenteDto;
import com.mercadolibre.hql_seguro_autos.dto.response.PatenteMarcaDto;
import com.mercadolibre.hql_seguro_autos.dto.response.VehicleResponseDto;

import java.util.List;

public interface IVehiculoService {

    VehicleResponseDto create(CreateVehiculoDto createVehiculoDto);

    List<PatenteDto> findAllPatentes();
    List<PatenteMarcaDto> findPatenteAndMarcaOrderByAnioFabricacion();
    List<PatenteDto> findPatentesWithMoreThan4WheelsAndCurrentYear();
}
