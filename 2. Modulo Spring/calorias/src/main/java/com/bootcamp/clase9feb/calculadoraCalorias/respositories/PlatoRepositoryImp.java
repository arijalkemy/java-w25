package com.bootcamp.clase9feb.calculadoraCalorias.respositories;

import com.bootcamp.clase9feb.calculadoraCalorias.entities.Alimento;
import com.bootcamp.clase9feb.calculadoraCalorias.entities.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImp {
    List<Plato> platos;
    IAlimentoRepository alimentoRepositoryImp;
    public PlatoRepositoryImp (AlimentoRepositoryImp alimentoRepositoryImp) {
        this.alimentoRepositoryImp = alimentoRepositoryImp;
        this.platos = new ArrayList<>();

        List<Alimento> alimentos = this.alimentoRepositoryImp.getAll();
        List<HashMap<Alimento, Integer>> ingredientes = new ArrayList<>();
        HashMap<Alimento, Integer> ingrediente = new HashMap<>();
        ingrediente.put(alimentos.get(3),1);
        ingrediente.put(alimentos.get(7),1);
        ingredientes.add(ingrediente);
        platos.add(new Plato("Pizza", ingredientes));

        List<HashMap<Alimento, Integer>> ingredientes2 = new ArrayList<>();
        HashMap<Alimento, Integer> ingrediente2 = new HashMap<>();
        ingrediente2.put(alimentos.get(12),3);
        ingrediente2.put(alimentos.get(9),2);
        ingredientes2.add(ingrediente);
        platos.add(new Plato("Plato loco", ingredientes2));

    }

    public Plato getByName(String name) {
        Optional<Plato> platoBuscado =  platos.stream().filter(a -> a.getName().equals(name)).findFirst();
        if(platoBuscado.isEmpty()) throw new RuntimeException("No se encontro el plato buscado");
        return platoBuscado.get();
    }
}
