package com.example.hqlsegurosvehiculos.service;

import com.example.hqlsegurosvehiculos.dto.response.PatenteAndYearDTO;
import com.example.hqlsegurosvehiculos.dto.response.PatentesDTO;
import com.example.hqlsegurosvehiculos.dto.response.SiniestrosDTO;
import com.example.hqlsegurosvehiculos.dto.response.VehiculoDTO;
import com.example.hqlsegurosvehiculos.dto.request.NuevoVehiculoDTO;

import java.util.List;

public interface IVehiculoService {
    List<PatentesDTO> findAllPatentes();
    List<SiniestrosDTO> findAllSiniestros();
    List<VehiculoDTO> findAll();
    NuevoVehiculoDTO create(NuevoVehiculoDTO vehiculo);
    List<PatenteAndYearDTO> getAllPatentesOrderbyYearFab();
    List<PatenteAndYearDTO> getAllVehiclesMoreThan4Wheels();
}
