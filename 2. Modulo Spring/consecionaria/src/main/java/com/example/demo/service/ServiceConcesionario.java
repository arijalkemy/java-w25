package com.example.demo.service;

import com.example.demo.dto.AutoUsadoDTO;
import com.example.demo.dto.AutoUsadoFullDTO;
import com.example.demo.repository.RepositoryConcesionario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceConcesionario {
    private final RepositoryConcesionario repositorio;

    public ServiceConcesionario(RepositoryConcesionario repositorio) {
        this.repositorio = repositorio;
    }

    public void agregarAuto(AutoUsadoDTO auto) {
        System.out.println("---- ENTRO A SERVICE Y LLAMO AL REPOSITORIO----");
        repositorio.agregarAuto(auto);
        System.out.println("Agregue un auto usado: "+auto);
    }

    public List<AutoUsadoDTO> traerAutosUsados(){
        System.out.println("Entre al service-----");
        return repositorio.traerAutosUsados();
    }

    public List<AutoUsadoDTO> traerAutosUsadosPorFechas(String since, String to){
        List<AutoUsadoDTO> listaDeAutos = repositorio.traerAutosUsados();
        LocalDate dateSince = LocalDate.parse(since);
        LocalDate dateTo = LocalDate.parse(to);

        List<AutoUsadoDTO> listaFiltrada = new ArrayList<>();

        for (AutoUsadoDTO auto : listaDeAutos) {
            LocalDate dateManufacturing = LocalDate.parse(auto.getManufacturingDate());
            if(dateManufacturing.isAfter(dateSince) && dateManufacturing.isBefore(dateTo)) {
                System.out.println("Dentro de fechas: "+ auto.getBrand());
                listaFiltrada.add(auto);
            }
        }
        return listaFiltrada;
    }

    public List<AutoUsadoDTO> traerAutosPorPrecios(String since, String to) {
        List<AutoUsadoDTO> listaDeAutos = repositorio.traerAutosUsados();
        int precioSince = Integer.parseInt(since);
        int precioTo = Integer.parseInt(to);

        return listaDeAutos.stream()
                .filter(auto -> Integer.parseInt(auto.getPrice()) >= precioSince && Integer.parseInt(auto.getPrice()) <= precioTo)
                .collect(Collectors.toList());
    }

    public AutoUsadoDTO trearPorId(String id){
        return repositorio.trarPorId(id);
    }
}
