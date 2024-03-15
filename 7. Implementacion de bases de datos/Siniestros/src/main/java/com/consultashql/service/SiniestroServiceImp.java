package com.consultashql.service;


import com.consultashql.DTO.SiniestroDTO;
import com.consultashql.model.Siniestro;
import com.consultashql.model.Vehiculo;
import com.consultashql.repository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class SiniestroServiceImp implements ISiniestroService{



    ISiniestroRepository iSiniestroRepository;
    IVehiculoService vehiculoService;
    ModelMapper modelMapper;

    public SiniestroServiceImp(ISiniestroRepository iSiniestroRepository, IVehiculoService vehiculoService){
        this.modelMapper = new ModelMapper();
        this.iSiniestroRepository = iSiniestroRepository;
        this.vehiculoService = vehiculoService;
    }

    public SiniestroDTO addNewSiniestro(SiniestroDTO siniestroDTO){
        Siniestro siniestro = modelMapper.map(siniestroDTO, Siniestro.class);
        Vehiculo vehiculo = vehiculoService.getVehiculoById(siniestroDTO.getVehiculo_denunciado());
        if (vehiculo != null) {
            siniestro.setVehiculo_denunciado(vehiculo);
            iSiniestroRepository.save(siniestro);
        } else {
            throw new RuntimeException("Vehiculo with id " + siniestroDTO.getVehiculo_denunciado() + " not found");
        }
        return siniestroDTO;
    }



    public List<SiniestroDTO> getAllSiniestros(){
        List<Siniestro> siniestroList = iSiniestroRepository.findAll();
        return siniestroList.stream().map(siniestro -> modelMapper.map(siniestro, SiniestroDTO.class)).toList();
    }

}
