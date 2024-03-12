package com.meli.seguros.service;

import com.meli.seguros.dto.*;
import com.meli.seguros.model.Siniestro;
import com.meli.seguros.model.Vehiculo;
import com.meli.seguros.repository.ISiniestroRepository;
import com.meli.seguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegurosService implements ISegurosService{
    IVehiculoRepository repoVehiculo;
    ISiniestroRepository repoSiniestro;
    public ModelMapper mapper = new ModelMapper();

    public SegurosService(IVehiculoRepository repoVehiculo, ISiniestroRepository repoSiniestro) {
        this.repoVehiculo = repoVehiculo;
        this.repoSiniestro = repoSiniestro;
    }

    public List<String> listarPatentes(){
        return  this.repoVehiculo.findAllPantentes();
    }

    @Override
    public ResNewVehiculoDto addNewVehiculo(NewVehiculoDto vehiculoDto) {
        Vehiculo newVehiculo = mapper.map(vehiculoDto,Vehiculo.class);
        return mapper.map(repoVehiculo.save(newVehiculo), ResNewVehiculoDto.class);
    }

    @Override
    public ResSiniestroDto addNewSiniestro(NewSiniestroDto siniestroDto) {
        Siniestro newSiniestro = mapper.map(siniestroDto, Siniestro.class);
        return mapper.map(repoSiniestro.save(newSiniestro), ResSiniestroDto.class);
    }


}
