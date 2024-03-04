package com.example.demo.repository;

import com.example.demo.dto.AutoUsadoDTO;
import com.example.demo.dto.AutoUsadoFullDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositoryConcesionario {
    private List<AutoUsadoDTO> autos = new ArrayList<>();

    public RepositoryConcesionario() {

    }

    public void agregarAuto(AutoUsadoDTO auto) {
        System.out.println("---- ENTRO A REPOSITORIO Y AGREGO EL AUTO----");
        autos.add(auto);
        System.out.println(auto);
    }

    public List<AutoUsadoDTO> traerAutosUsados() {
        System.out.println("Entre al repositorio-----");
        return autos;
    }

    public AutoUsadoDTO trarPorId(String id) {
        return autos.stream().filter(auto -> auto.getId().equals(id)).findFirst().orElse(null);
    }

}
