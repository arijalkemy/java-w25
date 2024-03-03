package Calorias.repository;

import Calorias.entity.Ingredientes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientesRepository {
    List<Ingredientes> ingredientes;

    public List<Ingredientes> AllIngredientes() {
        this.ingredientes = loadDataBase();
        return ingredientes;
    }

    private List<Ingredientes> loadDataBase() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            return mapper.readValue(jsonFile, new TypeReference<List<Ingredientes>>(){});
        } catch (IOException e) {
            System.out.println("No existe el archivo "+ e.getMessage());
        }
        return new ArrayList<>();
    }
}
