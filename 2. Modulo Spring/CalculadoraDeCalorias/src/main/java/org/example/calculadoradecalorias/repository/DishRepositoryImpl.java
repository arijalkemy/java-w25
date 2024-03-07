package org.example.calculadoradecalorias.repository;

import org.example.calculadoradecalorias.dto.DishDto;
import org.example.calculadoradecalorias.dto.IngredientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DishRepositoryImpl implements DishRepositoryInterface{

    @Autowired
    IngredientRepositoryImpl ingredientRepository = new IngredientRepositoryImpl();

    private List<DishDto> dishList = List.of(
            new DishDto("Changua", List.of(
                    ingredientRepository.findIngredientByName("Leche entera").get(),
                    ingredientRepository.findIngredientByName("Pan de trigo blanco").get(),
                    ingredientRepository.findIngredientByName("Huevo entero").get()
            )),
            new DishDto("Bandeja paisa", List.of(
                    ingredientRepository.findIngredientByName("Arroz blanco").get(),
                    ingredientRepository.findIngredientByName("Lentejas").get(),
                    ingredientRepository.findIngredientByName("Chicharrón").get(),
                    ingredientRepository.findIngredientByName("Chorizo").get()
            )),
            new DishDto("Sandwich", List.of(
                    ingredientRepository.findIngredientByName("Mortadela").get(),
                    ingredientRepository.findIngredientByName("Queso crema").get(),
                    ingredientRepository.findIngredientByName("Pan de trigo blanco").get()
            ))
    );

    @Override
    public Optional<DishDto> findOneDishByName(String name) {
        return dishList.stream().filter(dish -> dish.getName().equalsIgnoreCase(name)).findFirst();
    }
}
