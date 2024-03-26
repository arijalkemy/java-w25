package com.example.SegurosDeAutos.service;

import com.example.SegurosDeAutos.dto.RequestVehiculoDTO;
import com.example.SegurosDeAutos.dto.SiniestroDTO;
import com.example.SegurosDeAutos.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoServices {
    VehiculoDTO addVehiculo(RequestVehiculoDTO vehiculoDTO);
    VehiculoDTO getVehiculoById(Long id);
    List<VehiculoDTO> getVehiculos();
}
