package com.example.ejercicio_seguros.service;

import com.example.ejercicio_seguros.dto.*;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoDTO> listVehiculos();
    MensajeDTO guardarVehiculo(VehiculoDTO vehiculoDTO);

    List<PatenteDTO> listPatentesVehiculos();
    List<PatMarcaDto> listPaMarcaVehiculos();
    List<PatenteDTO> listPatentesVehiculosByRuedasAndAnio(Integer ruedas, Integer anio);
    List<PatMarModDTO> listVehiculoSiniestroByPerdida(double perdida);
    List<SiniestroDTO> listVehiculoSiniestroByPerdidaTotal(double perdida);
}
