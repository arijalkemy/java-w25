package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.MatriculaMarcaModeloDto;
import com.bootcamp.hql.dto.PatenteMarcaDto;
import com.bootcamp.hql.dto.PatentesDto;
import com.bootcamp.hql.model.Vehiculo;
import com.bootcamp.hql.model.VehiculoSiniestro;

import java.util.List;

public interface IVehiculoService {

    List<PatentesDto> ObtenerPatentesVehiculosRegistrados();
    List<PatenteMarcaDto> ObtenerPatentesYMarcaPorAnio();
    List<PatentesDto> ObtenerPatentesVehiculosMasDe4RuedasAnioActual();
    List<MatriculaMarcaModeloDto> ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000();
    List<VehiculoSiniestro> ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000ConPerdidaTotal();
}
