package com.mercadolibre.calculadoradecalorias.repository;

import com.mercadolibre.calculadoradecalorias.entity.Alimento;
import com.mercadolibre.calculadoradecalorias.entity.Plato;
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
        List<HashMap<Alimento, Integer>> listaIngredientes = new ArrayList<>();
        HashMap<Alimento, Integer> ingredientes = new HashMap<>();
        ingredientes.put(alimentos.get(3), 1);
        ingredientes.put(alimentos.get(7), 1);
        listaIngredientes.add(ingredientes);
        platos.add(new Plato("Pizza", listaIngredientes));

        List<HashMap<Alimento, Integer>> listaIngredientes2 = new ArrayList<>();
        HashMap<Alimento, Integer> ingredientes2 = new HashMap<>();
        ingredientes2.put(alimentos.get(12),3);
        ingredientes2.put(alimentos.get(9),2);
        listaIngredientes2.add(ingredientes2);
        platos.add(new Plato("Plato loco", listaIngredientes2));
    }

    public Plato getByName(String name) {
        Optional<Plato> platoBuscado =  platos.stream().filter(a -> a.getName().equals(name)).findFirst();
        if (platoBuscado.isEmpty()) throw new RuntimeException("No se encontro el plato buscado");
        return platoBuscado.get();
    }
}