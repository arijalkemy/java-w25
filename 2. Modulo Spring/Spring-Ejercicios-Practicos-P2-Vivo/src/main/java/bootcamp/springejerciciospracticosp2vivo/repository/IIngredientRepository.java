package bootcamp.springejerciciospracticosp2vivo.repository;

import bootcamp.springejerciciospracticosp2vivo.entity.Ingredient;
import bootcamp.springejerciciospracticosp2vivo.exception.IngredientNotFoundException;

public interface IIngredientRepository {

    Ingredient findByName(String name) throws IngredientNotFoundException;

}
