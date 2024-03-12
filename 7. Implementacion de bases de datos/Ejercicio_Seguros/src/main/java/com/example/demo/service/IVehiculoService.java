package com.example.demo.service;

import com.example.demo.dto.PatenteDto;
import com.example.demo.dto.PatenteYMarcaDto;
import com.example.demo.dto.PerdidaMayorADto;
import com.example.demo.dto.VehiculoSiniestroDto;

import java.util.List;

public interface IVehiculoService {

    List<PatenteDto> getPatentesRegistradas();

    List<PatenteYMarcaDto> getPatentesYMarcaPorAnio();

    List<PatenteDto> getCuatriRuedasYAnioCorriente();

    PerdidaMayorADto getMatriculaMarcaModeloPerdidaMayorA(int i);

    List<VehiculoSiniestroDto> getSumaMatriculaMarcaModeloPerdidaMayorA(int i);
}
