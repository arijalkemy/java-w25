package com.bootcamp.ejercicio_consultas_HQL.service;

import com.bootcamp.ejercicio_consultas_HQL.dto.request.ReqSiniestroDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.ResSiniestroDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.ResponseDTO;

import java.util.List;

public interface ISiniestroService {
    ResponseDTO create(ReqSiniestroDTO siniestroDTO);
    List<ResSiniestroDTO> getAll();
    ResSiniestroDTO getById(Long id);
}
