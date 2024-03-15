package com.consultashql.service;

import com.consultashql.DTO.VehiculoDTO;
import com.consultashql.DTO.VehiculoSiniestroDTO;
import com.consultashql.DTO.response.PatentesDTO;
import com.consultashql.DTO.response.PatentesMarcaDTO;
import com.consultashql.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    VehiculoDTO addNewVehiculo(VehiculoDTO vehiculoDTO);

    PatentesDTO getVehiculos();
    List<PatentesMarcaDTO> getPatenteMarca();

    VehiculoSiniestroDTO getVehiculoSiniestro(String x);

    PatentesDTO getRuedasAnio();

    Vehiculo getVehiculoById(Long vehiculoDenunciado);
}
