package com.meli.deportistas.repository;

import com.meli.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DeporteRepository {

    List<Deporte> deportes = new ArrayList<>();

    public DeporteRepository() {
        deportes.add(new Deporte("Futbol","profesional"));
        deportes.add(new Deporte("Tenis","amateur"));
    }

    public List<Deporte> findAll(){
        return this.deportes;
    }

    public Optional<Deporte> findSportByName(String nombre){
        return deportes.stream().filter(x -> x.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }
}
