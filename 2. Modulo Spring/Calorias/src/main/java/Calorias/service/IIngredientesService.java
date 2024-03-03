package Calorias.service;

import Calorias.entity.Ingredientes;
import Calorias.entity.IngredientesPlato;

import java.util.List;
import java.util.Optional;

public interface IIngredientesService {
    Ingredientes findIngrediente(IngredientesPlato ingredientePlato);
}
