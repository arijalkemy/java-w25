package com.bootcamp.hql.service.interfaces;

import com.bootcamp.hql.dto.MatriculaMarcaModeloDto;
import com.bootcamp.hql.dto.PatenteMarcaDto;
import com.bootcamp.hql.dto.PatentesDto;
import com.bootcamp.hql.dto.PerdidaTotalDto;

import java.util.List;

public interface IVehiculoService {
    //Listar las patentes de todos los vehículos registrados.
    List<PatentesDto> ObtenerPatentesVehiculosRegistrados();
    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    List<PatenteMarcaDto> ObtenerPatentesYMarcaPorAnno();
    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    List<PatentesDto> ObtenerPatentesVehiculosMasDe4RuedasAnnoActual();
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    List<MatriculaMarcaModeloDto> ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000();
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    List<MatriculaMarcaModeloDto> ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000ConPerdidaTotal();
    PerdidaTotalDto ObtenerPerdidaTotalSiniestrosMayorA10000();
}
