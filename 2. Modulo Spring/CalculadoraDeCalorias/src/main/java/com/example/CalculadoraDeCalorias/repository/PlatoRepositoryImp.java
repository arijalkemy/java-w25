package com.example.CalculadoraDeCalorias.repository;

import com.example.CalculadoraDeCalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PlatoRepositoryImp implements IPlatoRepository {

    private List<Plato> platos = Arrays.asList(
            new Plato("Pizza",Arrays.asList(
                    "Tomates","Zanahoria","Ajos"
            )),
            new Plato("Empanada",Arrays.asList(
                    "Berros","Berenjena","Calabaza"
            )),
            new Plato("Asado",Arrays.asList(
                    "Espinaca","Pimiento","Puerros"
            )),
            new Plato("Torta",Arrays.asList(
                    "Coco","Higos","Mora"
            ))
    );

    public Plato getPlatoByName(String nombre) {
        return this.platos.stream().filter(plato -> plato.getNombre().equals(nombre)).findFirst().get();
    }
}
