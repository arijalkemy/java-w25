package com.bootcamp.ejercicio_vehiculos_siniestros.service;

import com.bootcamp.ejercicio_vehiculos_siniestros.dto.response.PatenteDTO;
import com.bootcamp.ejercicio_vehiculos_siniestros.dto.response.PatenteMarcaDTO;
import com.bootcamp.ejercicio_vehiculos_siniestros.dto.response.PatenteMarcaModeloDTO;
import com.bootcamp.ejercicio_vehiculos_siniestros.dto.response.PerdidaTotalDTO;

import java.util.List;

public interface IVehiculoService {

    List<PatenteDTO> getPatentes();

    List<PatenteMarcaDTO> getPatenteAndMarca();

    List<PatenteDTO> getPatentesMoreThanFourWheelsThisYear();

    List<PatenteMarcaModeloDTO> getSiniestroPerdida();

    List<PerdidaTotalDTO> getPerdidatotal();
}
