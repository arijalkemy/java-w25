package com.dto.deportistas.repository;

import com.dto.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepositoryImp implements IGenericRepository<Deporte> {
    List<Deporte> deportes = new ArrayList<>();

    public DeporteRepositoryImp (){
        Deporte deporte1 = new Deporte("Futbol", "Basico");
        Deporte deporte2 = new Deporte("Voley", "Basico");
        Deporte deporte3 = new Deporte("Hockey", "Moderado");
        Deporte deporte4 = new Deporte("Snowboard", "Dificil");
        deportes.add(deporte1);
        deportes.add(deporte2);
        deportes.add(deporte3);
        deportes.add(deporte4);
    }
    @Override
    public List<Deporte> getLista() {
        return deportes;
    }

    public List<Deporte> findByName(String name){
        return (List<Deporte>) deportes.stream().filter(n-> n.getNombre().equals(name)).toList();
    }
}
