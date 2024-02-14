package com.calorias.SpringInyeccion.repository;

import com.calorias.SpringInyeccion.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PlatosRepository {

    private List<Plato> platos = Arrays.asList(
            new Plato("Pizza",Arrays.asList(
                    "Tomates","Zanahoria","ajos"
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
    public Plato obtenerIngrediente(String nombre){
        return this.platos.stream().filter(plato -> plato.getNombre().equals(nombre)).findFirst().get();
    }
}
