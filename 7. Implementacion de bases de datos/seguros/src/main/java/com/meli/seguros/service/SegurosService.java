package com.meli.seguros.service;

import com.meli.seguros.dto.request.NewSiniestroDto;
import com.meli.seguros.dto.request.NewVehiculoDto;
import com.meli.seguros.dto.response.*;
import com.meli.seguros.model.Siniestro;
import com.meli.seguros.model.Vehiculo;
import com.meli.seguros.repository.ISiniestroRepository;
import com.meli.seguros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
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

    @Override
    public List<ResSiniestroDto> getAllSiniestros() {
        List<Siniestro> res = repoSiniestro.findAll();
        return res.stream().map(s -> mapper.map(s, ResSiniestroDto.class)).toList();
    }

    @Override
    public List<ResVehiculoDto> getAllVehiculos() {
        List<Vehiculo> res = repoVehiculo.findAll();
        return res.stream().map(s -> mapper.map(s, ResVehiculoDto.class)).toList();
    }

    @Override
    public ResVehiculoDto addNewVehiculo(NewVehiculoDto vehiculoDto) {
        Vehiculo newVehiculo = mapper.map(vehiculoDto,Vehiculo.class);
        return mapper.map(repoVehiculo.save(newVehiculo), ResVehiculoDto.class);
    }

    @Override
    public ResSiniestroDto addNewSiniestro(NewSiniestroDto siniestroDto) {
        Siniestro newSiniestro = mapper.map(siniestroDto, Siniestro.class);
        return mapper.map(repoSiniestro.save(newSiniestro), ResSiniestroDto.class);
    }

    public List<PatenteDto> listarPatentes(){
        return repoVehiculo.findAllPantentes().stream()
                .map(PatenteDto::new)
                .toList();
    }

    @Override
    public List<PatenteMarcaDto> listarAllPatenteYMarcaSortByAnioFabricacion() {
        List<Object[]> resQuery = repoVehiculo.findAllPantenteYMarcaOrderAnioFabricacion();
        return resQuery.stream()
                .map(obj -> new PatenteMarcaDto((String) obj[0], (String) obj[1]))
                .toList();
    }

    @Override
    public List<PatenteDto> listarPatentesBy4WheelsOrMoreAndFabricatedWithinCurrentYear() {
        List<String> resQuery = repoVehiculo.findPatenteByCantidadRuedasYAnioFabricacion(Year.now().getValue());
        return resQuery.stream().map(s -> new PatenteDto(s)).toList();
    }

    @Override
    public List<PatenteMarcaModeloDto> listarByPerdidaSiniestroMayorA10000() {
        List<Object[]> resQuery = repoVehiculo.findAllVehiculosSiniestrosWithPerdidaMayorDeDiezMilPesos();

        return resQuery.stream()
                .map(obj -> new PatenteMarcaModeloDto((String) obj[0], (String) obj[1], (String) obj[2]))
                .toList();
    }

    @Override
    public VehiculoSiniestroDTO listarByPerdidaSiniestroMayorA10000ShowTotalLoss() {
        List<Object[]> resQuery = repoVehiculo.findAllVehiculosSiniestrosWithPerdidaMayorDeDiezMilPesosAndGetLoss();
        List<PatenteMarcaModeloDto> vehiculos = new ArrayList<>();
        Double totLoss = 0.0;
        for(Object[] obj : resQuery) {
            vehiculos.add(new PatenteMarcaModeloDto((String) obj[0], (String) obj[1], (String) obj[2]));
            totLoss += (Double) obj[3];
        }
        return new VehiculoSiniestroDTO(vehiculos, totLoss);

    }


}
