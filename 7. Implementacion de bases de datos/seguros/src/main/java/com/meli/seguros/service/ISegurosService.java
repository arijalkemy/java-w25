package com.meli.seguros.service;

import com.meli.seguros.dto.request.NewSiniestroDto;
import com.meli.seguros.dto.request.NewVehiculoDto;
import com.meli.seguros.dto.response.*;

import java.util.List;

public interface ISegurosService {
    ResVehiculoDto addNewVehiculo(NewVehiculoDto v);
    ResSiniestroDto addNewSiniestro(NewSiniestroDto s);
    List<ResSiniestroDto> getAllSiniestros();
    List<ResVehiculoDto> getAllVehiculos();
    List<PatenteDto> listarPatentes();
    List<PatenteMarcaDto> listarAllPatenteYMarcaSortByAnioFabricacion();
    List<PatenteDto> listarPatentesBy4WheelsOrMoreAndFabricatedWithinCurrentYear();
    List<PatenteMarcaModeloDto> listarByPerdidaSiniestroMayorA10000();
    VehiculoSiniestroDTO listarByPerdidaSiniestroMayorA10000ShowTotalLoss();

    

}
