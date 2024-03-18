package com.bootcamp.ejercicio_consultas_HQL.service;

import com.bootcamp.ejercicio_consultas_HQL.dto.request.ReqVehiculoDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.*;

import java.util.List;

public interface IVehiculoService {
    ResponseDTO createVehiculo(ReqVehiculoDTO reqVehiculoDTO);
    List<ResVehiculoDTO> getAllVehiculos();
    ResVehiculoDTO getById(Long id);
    List<PatenteDTO> getAllPatentes();
    List<PatenteYMarcaDTO> getAllPatenteYMarcaOrdenados();
    List<PatenteDTO> getAllPatenteThisYear();
    List<PatenteMarcaModeloDTO> getAllPatenteMarcaModelo();
    List<PatenteMarcaModeloPerdidaTotalDTO> getAllPatenteMarcaModeloPerdidaTotal();
}
