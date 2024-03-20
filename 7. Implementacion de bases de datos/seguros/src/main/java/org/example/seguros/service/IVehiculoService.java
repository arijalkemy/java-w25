package org.example.seguros.service;

import org.example.seguros.dto.request.VehiculoReqDTO;
import org.example.seguros.dto.response.VehiculoPatYMarcaRespDTO;
import org.example.seguros.dto.response.VehiculoRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVehiculoService {

    VehiculoRespDTO crearVehiculo(VehiculoReqDTO vehiculoDTO);

    VehiculoRespDTO getVehiculoById(Long id);

    List<String> findAllPatentes();

    List<VehiculoPatYMarcaRespDTO> findAllPatentesAndMarcaOrderByAnioFabricacion();

    List<String> findPatentesVehiculosMasCuatroRuedasByAnioActual();
}
