package com.mercadolibre.empresadeseguros.service;

import com.mercadolibre.empresadeseguros.dto.request.CreateVehiculoDto;
import com.mercadolibre.empresadeseguros.dto.response.VehiculoDto;

import java.util.List;

public interface IVehiculoService {
    public VehiculoDto create(CreateVehiculoDto createVehiculoDto);
    public List<VehiculoDto> getAll();
}
