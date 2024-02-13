package org.calculadoracalorias.service;

import org.calculadoracalorias.dto.response.IngredienteResponseDTO;
import org.calculadoracalorias.dto.response.PlatoResponseDTO;
import org.calculadoracalorias.entity.Ingrediente;
import org.calculadoracalorias.entity.IngredienteDelPlato;
import org.calculadoracalorias.entity.Plato;
import org.calculadoracalorias.entity.Receta;
import org.calculadoracalorias.repository.IngredientesRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Autowired
    IngredientesRepositoryImpl repo;

    Receta pizza = new Receta("Pizza", List.of(
            new IngredienteDelPlato(repo.getByName("Harina de Trigo Refinada"), 200.0),
            new IngredienteDelPlato(repo.getByName("Salsa de Tomate en Conserva"), 100.0),
            new IngredienteDelPlato(repo.getByName("Queso crema"), 150.0)
    ));

    public List<Ingrediente> getAllIngredientes() {
        return repo.getAll();
    }

    public List<Ingrediente> getReceta(Plato p) {
        Double totalCals = 0.0;
        PlatoResponseDTO resDTO = new PlatoResponseDTO();

        if (p.getNombre().equalsIgnoreCase("Pizza")){
            for (IngredienteDelPlato i : pizza.getIngredientes()) {
                resDTO.getIngredientes().add(new IngredienteResponseDTO(i.getIngrediente(),
                        i.getIngrediente().getCalories() * 0.01 * i.getPeso(),
                        i.getPeso()));
            }
        }
        totalCals = resDTO.getIngredientes().stream()
                .mapToDouble(IngredienteResponseDTO::getCalorias)
                .sum();

        resDTO.setIngredienteMasCalorico(
                resDTO.getIngredientes().stream().max(IngredienteResponseDTO::getCalorias);
        );
        resDTO.setTotalCalories(totalCals);

        return ;

    }


}
