package calculadora_calorias.repository;

import calculadora_calorias.entity.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    public List<Ingrediente> getAll();
    public Ingrediente getIngredienteByName(String name);
}
