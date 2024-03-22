package com.mercadolibre.empresadeseguros.service;

import com.mercadolibre.empresadeseguros.dto.request.CreateSiniestroDto;
import com.mercadolibre.empresadeseguros.dto.response.SiniestroDto;

import java.util.List;

public interface ISiniestroService {
    public SiniestroDto create(CreateSiniestroDto createSiniestroDto);
    public List<SiniestroDto> getAll();
}
