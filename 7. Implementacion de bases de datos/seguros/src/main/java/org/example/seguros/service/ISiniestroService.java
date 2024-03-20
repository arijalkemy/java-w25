package org.example.seguros.service;

import org.example.seguros.dto.response.VehiculoPatMarYModRespDTO;

import java.util.List;

public interface ISiniestroService {

    public List<VehiculoPatMarYModRespDTO> findPatenteMarcaModeloSiniestroMayorA10000();

    public List<DTO> findPatenteMarcaModeloSiniestroMayorA10000MostrarPerdidaTotal();
}
