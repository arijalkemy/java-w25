package bootcamp.springejerciciospracticosp2vivo.repository;

import bootcamp.springejerciciospracticosp2vivo.entity.Ingredient;
import bootcamp.springejerciciospracticosp2vivo.exception.IngredientNotFoundException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IIngredientRepository {

    @Override
    public Ingredient findByName(String name) throws IngredientNotFoundException {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
            return ingredients.stream().filter(i -> i.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
        } catch (IOException e) {
            throw new IngredientNotFoundException(name);
        }
    }

}
