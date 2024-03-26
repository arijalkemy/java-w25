package com.example.SegurosDeAutos.service;


import com.example.SegurosDeAutos.dto.RequestSiniestroDTO;
import com.example.SegurosDeAutos.dto.SiniestroDTO;
import com.example.SegurosDeAutos.entity.Siniestro;
import com.example.SegurosDeAutos.entity.Vehiculo;
import com.example.SegurosDeAutos.exception.NotFoundException;
import com.example.SegurosDeAutos.repository.ISiniestroRepository;
import com.example.SegurosDeAutos.repository.IVehiculoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroServices implements ISiniestroServices{


    private final IVehiculoRepository iVehiculoRepository;
    private final ISiniestroRepository iSiniestroRepository;
    private final ModelMapper modelMapper;

    public SiniestroServices(IVehiculoRepository iVehiculoRepository, ISiniestroRepository iSiniestroRepository, ModelMapper modelMapper) {
        this.iVehiculoRepository = iVehiculoRepository;
        this.iSiniestroRepository = iSiniestroRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SiniestroDTO addSiniestro(RequestSiniestroDTO requestSiniestroDTO) {
        /*Siniestro siniestro = modelMapper.map(requestSiniestroDTO, Siniestro.class);
        iSiniestroRepository.save(siniestro);
        return modelMapper.map(requestSiniestroDTO, SiniestroDTO.class);*/

        Vehiculo vehiculo = iVehiculoRepository.findById(requestSiniestroDTO.getIdVehiculo())
                .orElseThrow(() -> new NotFoundException("Vehiculo no encontrado"));

        Siniestro siniestro = new Siniestro();
        siniestro.setFechaSiniestro(requestSiniestroDTO.getFechaSiniestro());
        siniestro.setPerdidaEconomica(requestSiniestroDTO.getPerdidaEconomica());

        siniestro.setVehiculoDenunciado(vehiculo);

        return modelMapper.map(iSiniestroRepository.save(siniestro), SiniestroDTO.class);
    }

    @Override
    public SiniestroDTO getSiniestroById(Long id) {
        Siniestro siniestro = iSiniestroRepository.findById(id).orElseThrow( () -> new NotFoundException("Siniestro no encontrado!"));
        return modelMapper.map(siniestro, SiniestroDTO.class);
    }

    @Override
    public List<SiniestroDTO> getSiniestros() {
        List<Siniestro> siniestros = iSiniestroRepository.findAll();
        return siniestros.stream().map(s -> modelMapper.map(s, SiniestroDTO.class)).toList();
    }
}
