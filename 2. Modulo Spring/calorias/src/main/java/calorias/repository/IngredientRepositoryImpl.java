package calorias.repository;

import calorias.dto.IngredientCaloriesDTO;
import calorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository{

    private List<IngredientCaloriesDTO> ingredientsCaloriesDatabase;

    public IngredientRepositoryImpl() {
        ingredientsCaloriesDatabase = loadData();
    }


    private List<IngredientCaloriesDTO> loadData() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientCaloriesDTO>> typeRef = new TypeReference<>() {
        };
        List<IngredientCaloriesDTO>  ingredientsCaloriesList = null;
        try {
            // leer datos json y mapear a lista de ingredientes
            ingredientsCaloriesList = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredientsCaloriesList;
    }

    @Override
    public IngredientCaloriesDTO findCaloriesForIngredient(String ingredientName) {

        Optional<IngredientCaloriesDTO> match =
                ingredientsCaloriesDatabase.stream()
                        .filter(iDTO -> iDTO.getName().equals(ingredientName)).findFirst();
        IngredientCaloriesDTO ingredientCalories = null;
        if (match.isPresent()) {
            ingredientCalories = match.get();
        }
        return ingredientCalories;
    }
}
