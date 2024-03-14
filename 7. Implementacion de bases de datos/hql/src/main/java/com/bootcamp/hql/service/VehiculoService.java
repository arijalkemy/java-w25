package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.MatriculaMarcaModeloDto;
import com.bootcamp.hql.dto.PerdidaTotalDto;
import com.bootcamp.hql.dto.PatenteMarcaDto;
import com.bootcamp.hql.dto.PatentesDto;
import com.bootcamp.hql.model.Siniestro;
import com.bootcamp.hql.model.Vehiculo;
import com.bootcamp.hql.repository.interfaces.IVehiculoRepository;
import com.bootcamp.hql.service.interfaces.IVehiculoService;
import com.bootcamp.hql.utils.Mapper;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class VehiculoService implements IVehiculoService {

    IVehiculoRepository vehiculoRepository;
    public VehiculoService(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
        loadData();
    }

    //Listar las patentes de todos los vehículos registrados.
    @Override
    public List<PatentesDto> ObtenerPatentesVehiculosRegistrados() {
        List<String> vehiculoLista = vehiculoRepository.findVehiculoByPatente();
        return vehiculoLista.stream().map(PatentesDto::new).toList();
    }

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Override
    public List<PatenteMarcaDto> ObtenerPatentesYMarcaPorAnno() {
        List<String[]> vehiculoLista = vehiculoRepository.findVehiculosOrderByAnnoFabricacion();
        return vehiculoLista.stream().map(v -> new PatenteMarcaDto(v[0],v[1])).toList();
    }

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Override
    public List<PatentesDto> ObtenerPatentesVehiculosMasDe4RuedasAnnoActual() {
        int ruedas = 4;
        Year year = Year.of(LocalDate.now().getYear());
        List<Vehiculo> vehiculoLista = vehiculoRepository.findVehiculoByRuedasIsGreaterThanEqualAndAnnoFabricacion(ruedas, year );
        return vehiculoLista.stream().map(v -> Mapper.getMapper().map(v,PatentesDto.class)).toList();
    }
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.

    @Override
    public List<MatriculaMarcaModeloDto> ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000() {
        return vehiculoRepository.findVehiculoBySiniestroWithLossGreater(10000.0).stream().map(v -> Mapper.getMapper().map(v,MatriculaMarcaModeloDto.class)).toList();
    }
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Override
    public List<MatriculaMarcaModeloDto> ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000ConPerdidaTotal() {
        return vehiculoRepository.findByPerdidaEconomicaGreaterThan(10000.0).stream().map(o -> new MatriculaMarcaModeloDto((String) o[0], (String) o[1], (String) o[2])).toList();
    }

    @Override
    public PerdidaTotalDto ObtenerPerdidaTotalSiniestrosMayorA10000() {
        return new PerdidaTotalDto(vehiculoRepository.findByPerdidaEconomicaGreaterThanAndSumPerdidaEconomica(10000.0));
    }

    private void loadData(){
        List<Vehiculo> listaVehiculos = new ArrayList<>(
                Arrays.asList(
                        new Vehiculo(null, "ASD12D", "Toyota", "Corolla", Year.of(2024), 4, new HashSet<>(
                                List.of(
                                        new Siniestro(null, LocalDate.of(2022, 1, 1), 15000.00),
                                        new Siniestro(null,LocalDate.of(2022, 2, 15), 2000.00)))),
                        new Vehiculo(null, "DEF456", "Chevrolet", "Cruze", Year.of(2018), 4, new HashSet<>(List.of( new Siniestro(null,LocalDate.of(2022, 2, 15), 2000.00)))),
                        new Vehiculo(null, "1234", "Honda", "Civic", Year.of(2017), 4, new HashSet<>(List.of( new Siniestro(null,LocalDate.of(2024, 4, 15), 12000.00),
                                new Siniestro(null,LocalDate.of(2019, 4, 15), 11000.00)))),
                        new Vehiculo(null, "5678", "Nissan", "Altima", Year.of(2022), 4, null)
                )
        );
        vehiculoRepository.saveAll(listaVehiculos);
    }
}
