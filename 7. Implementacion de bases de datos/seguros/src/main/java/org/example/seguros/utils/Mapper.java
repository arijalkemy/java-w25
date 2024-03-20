package org.example.seguros.utils;

import org.example.seguros.dto.request.VehiculoReqDTO;
import org.example.seguros.dto.response.VehiculoPatYMarcaRespDTO;
import org.example.seguros.dto.response.VehiculoRespDTO;
import org.example.seguros.entity.Vehiculo;
import org.example.seguros.repository.proyection.PatenteMarca;

public class Mapper {
    public static VehiculoRespDTO vehiculoToRespDTO(Vehiculo vehiculo) {
        return new VehiculoRespDTO(
                vehiculo.getId(),
                vehiculo.getPatente(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnioFabricacion(),
                vehiculo.getCantidadRuedas(),
                vehiculo.getSiniestroList()
        );
    }


    public static VehiculoReqDTO vehiculoToReqDTO(Vehiculo vehiculo) {
        return new VehiculoReqDTO(
                vehiculo.getPatente(),
                vehiculo.getMarca(),
                vehiculo.getModelo(),
                vehiculo.getAnioFabricacion(),
                vehiculo.getCantidadRuedas(),
                vehiculo.getSiniestroList()
        );
    }

    public static VehiculoPatYMarcaRespDTO patenteMarcaToRespDTO(PatenteMarca vehiculo) {
        return new VehiculoPatYMarcaRespDTO(
                vehiculo.getPatente(),
                vehiculo.getMarca()
        );
    }
    public static Vehiculo VehiculoReqDTOToVehiculo(VehiculoReqDTO vehiculoReqDTO) {
        return new Vehiculo(
                vehiculoReqDTO.patente(),
                vehiculoReqDTO.marca(),
                vehiculoReqDTO.modelo(),
                vehiculoReqDTO.anioFabricacion(),
                vehiculoReqDTO.cantidadRuedas(),
                vehiculoReqDTO.siniestroList()
        );
    }
}
