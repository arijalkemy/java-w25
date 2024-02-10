package calculadora_calorias.repository;

import calculadora_calorias.entity.Plato;

import java.util.List;

public interface IPlatoRepository {
    public List<Plato> getAll();
    public Plato getPlatoByName(String name);
}
