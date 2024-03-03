package Calorias.repository;

import Calorias.entity.IngredientesPlato;
import Calorias.entity.Plato;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatosRepository {
    List<Plato> platos;

    public List<Plato> allPlatos() {
        this.platos = loadData();
        return platos;
    }

    public List<Plato> loadData(){
        List<IngredientesPlato> ingredientesPizza = new ArrayList<>();
        ingredientesPizza.add(new IngredientesPlato("Aceitunas verdes", 4));
        ingredientesPizza.add(new IngredientesPlato("Alcachofas",1));
        ingredientesPizza.add(new IngredientesPlato("Berenjena",3));
        ingredientesPizza.add(new IngredientesPlato("Champiñón y otras setas",2));

        List<IngredientesPlato> ingredientesSopa = new ArrayList<>();
        ingredientesSopa.add(new IngredientesPlato("Coliflor",4));
        ingredientesSopa.add(new IngredientesPlato("Alcachofas",1));
        ingredientesSopa.add(new IngredientesPlato("Calabaza",3));
        ingredientesSopa.add(new IngredientesPlato("Champiñón y otras setas",2));

        List<Plato> platos = List.of(new Plato("Pizza",ingredientesPizza),new Plato("Sopa",ingredientesSopa));
        return platos;
    }
}
