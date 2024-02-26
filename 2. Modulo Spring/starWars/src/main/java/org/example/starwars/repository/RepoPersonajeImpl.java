package org.example.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RepoPersonajeImpl implements IRepo<Personaje>{
    private List<Personaje> listaPersonajes;

    public RepoPersonajeImpl(){
        this.listaPersonajes = new ArrayList<>();
    }
    @Override
    public List<Personaje> findAll() {
        return this.listaPersonajes;
    }

    @Override
    public void add(Personaje o) {
        this.listaPersonajes.add(o);
    }

    @Override
    public void cargar() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonfile = null;
        try{
            jsonfile = ResourceUtils.getFile("classpath:starwars.json");
            this.listaPersonajes = mapper.readValue(jsonfile, new TypeReference<List<Personaje>>() {
            });
        }catch (IOException exception){
            System.out.println("No existe el archivo " + exception.getMessage());
        }
    }
}
