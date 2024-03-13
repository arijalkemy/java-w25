package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.PlatesAndBrandsDTO;
import com.example.ejemplo_jpa.dto.SiniestroDTO;
import com.example.ejemplo_jpa.dto.VehiculoDTO;
import com.example.ejemplo_jpa.model.PatenteMarca;
import com.example.ejemplo_jpa.model.Siniestro;
import com.example.ejemplo_jpa.model.Vehiculo;
import com.example.ejemplo_jpa.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class VehiculoSiniestroService {

    IVehiculoRepository vehiculoRepository;

    ModelMapper mapper = new ModelMapper();

    public VehiculoSiniestroService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    /*public List<Movie> getMoviesByName(String name) {
        return vehiculoRepository.findMovieByTitle(name);
    }*/

    public void saveVehicle(VehiculoDTO vehiculoDTO) {
        Vehiculo vehic = mapper.map(
                vehiculoDTO,
                Vehiculo.class
        );
        vehiculoRepository.save(
                vehic
        );
    }

    public List<String> getAllPatentes() {
        return vehiculoRepository.listAllVehiclePlates();
    }

    public List<PlatesAndBrandsDTO> getAllVehiculosPatentesYMarcasPorAnio() {

        List<PatenteMarca> resultado = vehiculoRepository.listAllVehiclePlatesAndBrands();
        return resultado
                .stream()
                .map(pm -> new PlatesAndBrandsDTO(pm.getPatente(), pm.getMarca()))
                .toList();
    }

    public List<String> getAllVehiculosPlatesPorRuedasYAnio() {
        return vehiculoRepository.listAllVehiclePlatesByWheelsAndCurrentYear(2024);
    }

    public void saveSiniestro(SiniestroDTO siniestroDTO) {
        Vehiculo vehiculo = vehiculoRepository.findById(siniestroDTO.getIdVehiculo()).get();

        Siniestro siniestro = new Siniestro(
                null,
                siniestroDTO.getFechaSiniestro(),
                siniestroDTO.getPerdidaEconomica(),
                vehiculo
        );

        vehiculo.getSiniestros().add(siniestro);

        vehiculoRepository.save(vehiculo);
    }
}
