package com.example.excalorias.repository.impl;

import com.example.excalorias.model.Ingrediente;
import com.example.excalorias.model.Plato;
import com.example.excalorias.repository.IIngredienteRepository;
import com.example.excalorias.repository.IPlatoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class IPlatoRepositoryImpl implements IPlatoRepository {
    private List<Plato> platos;

    public IPlatoRepositoryImpl(IIngredienteRepository ingredienteRepository) {
        List<Ingrediente> ingredientes = ingredienteRepository.findAllIngredientes();
        this.platos = new ArrayList<>(List.of(
                new Plato("Polenta con salsa", List.of(ingredientes.get(238), ingredientes.get(303))),
                new Plato("Milanesa con pure", List.of(ingredientes.get(43), ingredientes.get(21))),
                new Plato("Milanesa con fritas", List.of(ingredientes.get(12), ingredientes.get(23)))
        ));
    }

    @Override
    public List<Plato> findAllPlatos(){
        return this.platos;
    }
    @Override
    public Plato findPlatoByName(String name){
        return this.platos.stream().filter(plato -> plato.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}
