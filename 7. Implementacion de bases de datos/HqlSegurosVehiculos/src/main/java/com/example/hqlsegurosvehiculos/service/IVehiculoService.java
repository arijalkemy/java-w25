package com.example.hqlsegurosvehiculos.service;

import com.example.hqlsegurosvehiculos.dto.response.VehiculoDTO;
import com.example.hqlsegurosvehiculos.dto.response.request.NuevoVehiculoDTO;

import java.util.List;

public interface IVehiculoService {

    public List<String> findAllPatentes();
    List<VehiculoDTO> findAll();

    NuevoVehiculoDTO create(NuevoVehiculoDTO vehiculo);
}
