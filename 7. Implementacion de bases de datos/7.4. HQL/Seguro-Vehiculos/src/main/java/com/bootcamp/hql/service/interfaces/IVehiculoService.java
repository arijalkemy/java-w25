package com.bootcamp.hql.service.interfaces;

import com.bootcamp.hql.model.dto.CreateSiniestroDto;
import com.bootcamp.hql.model.dto.CreateVehiculoDto;
import com.bootcamp.hql.model.dto.LinkSiniestroDto;
import com.bootcamp.hql.model.dto.MessageDto;
import com.bootcamp.hql.model.projection.*;

import java.util.List;

public interface IVehiculoService {
    //Listar las patentes de todos los vehículos registrados.
    List<SelectPatente> getAllPatentes();
    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    List<SelectPatenteAndMarca> getAllPatentesAndMarcaByAnnoFabricacion();
    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    List<SelectPatenteByRuedasAndAnnoFabricacion> getPatenteByRuedasAndAnnoFabricacion();
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    List<SelectByPerdidaEconomica> getMatriculaAndMarcaAndModeloByPerdidaEconomica();
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    VehiculoSiniestro getMatriculaAndMarcaAndModeloAndPerdidaTotalByPerdidaEconomica();

    MessageDto createVehiculos(List<CreateVehiculoDto> vehiculoACrear);
    MessageDto createSiniestros(List<CreateSiniestroDto> siniestroACrear);
    MessageDto asociarSiniestroAVehiculo(LinkSiniestroDto linkSiniestroDto);
}