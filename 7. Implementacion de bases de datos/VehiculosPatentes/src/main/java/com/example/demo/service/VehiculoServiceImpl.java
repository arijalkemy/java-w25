package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.repository.IVehiculoRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VehiculoServiceImpl implements IVehiculoService{
    private final IVehiculoRepository vehiculoRepository;
    @Override
    public List<PatenteDto> getPatentesRegistradas(){
        List<PatenteDto> patenteDtos = new ArrayList<>();
        vehiculoRepository.findPatentes().forEach(s -> patenteDtos.add(new PatenteDto(s)));
        return patenteDtos;
    }

    @Override
    public List<PatenteYMarcaDto> getPatentesYMarcaPorAnio(){
        return vehiculoRepository.findByPatenteAndMarcaPorAnio().stream()
                .map(vehiculo -> new PatenteYMarcaDto(vehiculo.getPatente(), vehiculo.getMarca()))
                .toList();
    }


    @Override
    public List<PatenteDto> getCuatriRuedasYAnioCorriente() {
        List<PatenteDto> lista = new ArrayList<>();
        for(String p : vehiculoRepository.findPatentesRuedasYAnio()) {
            lista.add(new PatenteDto(p));
        }
        return lista;
    }

    @Override
    public PerdidaMayorADto getMatriculaMarcaModeloPerdidaMayorA(int i){
        List<MatriculaMarcaModeloDto> vehiculos = vehiculoRepository.findSiniestroMayorA(i).stream()
                .map(v -> new MatriculaMarcaModeloDto(v.getPatente(), v.getMarca(), v.getModelo()))
                .toList();
        return new PerdidaMayorADto(vehiculos);
    }

    @Override
    public List<VehiculoSiniestroDto> getSumaMatriculaMarcaModeloPerdidaMayorA(int i){
        VehiculoSiniestroDto vehiculoSiniestroDto = new VehiculoSiniestroDto(
                this.getMatriculaMarcaModeloPerdidaMayorA(i),
                Double.valueOf(vehiculoRepository.findSumaSiniestroMayorA(i)));
        return new ArrayList<>(List.of(vehiculoSiniestroDto));
        //Prueba cuando puedas y nos cuentas --> dale, ahi lo pruebo y lo subo a slack --> funciona!!
        //Perfecto, gracias!!
        // gracias a vos Juan! Ahi lo subo al slack!
    }
}
