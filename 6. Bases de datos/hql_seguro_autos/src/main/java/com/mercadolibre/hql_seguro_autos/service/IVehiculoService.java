package com.mercadolibre.hql_seguro_autos.service;

import com.mercadolibre.hql_seguro_autos.dto.request.CreateVehiculoDto;
import com.mercadolibre.hql_seguro_autos.dto.response.*;

import java.util.List;

public interface IVehiculoService {

    VehicleDto create(CreateVehiculoDto createVehiculoDto);

    List<PatenteDto> findAllPatentes();
    List<PatenteMarcaDto> findPatenteAndMarcaOrderByAnioFabricacion();
    List<PatenteDto> findPatentesWithMoreThan4WheelsAndCurrentYear();

    List<PatenteMarcaModeloDto> findMarcaPatenteModeloWithSiniestrosWithPerdidasGreaterThan10000();

    VehiculoSiniestroDto findPerdidasSumMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan10000();
}
