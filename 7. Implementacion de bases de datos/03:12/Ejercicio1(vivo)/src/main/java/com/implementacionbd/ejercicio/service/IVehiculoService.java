package com.implementacionbd.ejercicio.service;

import java.util.List;

import com.implementacionbd.ejercicio.dto.MessageResDTO;
import com.implementacionbd.ejercicio.dto.PatenteDTO;
import com.implementacionbd.ejercicio.dto.PatenteMarcaDTO;
import com.implementacionbd.ejercicio.dto.PerdidaMayorDTO;
import com.implementacionbd.ejercicio.dto.SiniestroReqDTO;
import com.implementacionbd.ejercicio.dto.VehiculoReqDTO;

public interface IVehiculoService {
    List<PatenteDTO> getPatentesRegistradas();

    List<PatenteMarcaDTO> getPatentesYMarcaPorAnio();

    List<PatenteDTO> getCuatriRuedasYAnioCorriente();

    PerdidaMayorDTO getMatriculaMarcaModeloPerdidaMayorA(int i);

    public MessageResDTO postVehiculo(VehiculoReqDTO vehiculoReqDTO);

    public MessageResDTO postSiniestro(Long vehiculoId, SiniestroReqDTO siniestroReqDTO);

}
