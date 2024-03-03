package Calorias.service;

import Calorias.entity.Ingredientes;
import Calorias.entity.IngredientesPlato;
import Calorias.repository.IngredientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class IngredientesService implements IIngredientesService{
    @Autowired
    IngredientesRepository ingredientesRepository;

    @Override
    public Ingredientes findIngrediente(IngredientesPlato ingredientePlato){
        List<Ingredientes> ingredientesCocina= ingredientesRepository.AllIngredientes();

        return ingredientesCocina.stream().
                filter(ic -> ic.getName().equals(ingredientePlato.getNombre())).
                findFirst().orElse(null);
    }
}
