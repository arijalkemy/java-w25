package com.bootcamp.clase9feb.calculadoraCalorias.respositories;

import com.bootcamp.clase9feb.calculadoraCalorias.entities.Alimento;
import com.bootcamp.clase9feb.starWars.entities.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlimentoRepositoryImp implements IAlimentoRepository {
    List<Alimento> alimentos;

    public AlimentoRepositoryImp(){
        this.alimentos = new ArrayList<>();
        loadJson();
    }
    private void loadJson () {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null; // objeto de file declarado
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json"); // abre archivo
            alimentos = mapper.readValue(jsonFile, new TypeReference<List<Alimento>>() {});
            // transforma lo q hay en el primero al tipo del segundo
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Alimento getAlimento(String name) {
        Optional<Alimento> alimentoBuscado =  alimentos.stream().filter(a -> a.getName().equals(name)).findFirst();
        if(alimentoBuscado.isEmpty()) throw new RuntimeException("No se encontro el alimento buscado");
        return alimentoBuscado.get();
    }

    @Override
    public List<Alimento> getAll() {
        return this.alimentos;
    }
}
