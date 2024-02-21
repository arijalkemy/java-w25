package ejercicio.caloriascalcu.repository;

import ejercicio.caloriascalcu.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@Repository
@Data
public class IngredienteRepository {
    List<Ingrediente> ingredientes = new ArrayList<>();
    public void leerIngredientesJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:static.food.json");
            this.ingredientes = objectMapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        }catch (IOException e){
            System.out.println("No es posible leer el archivo JSON " + e);
        }

    }

}
