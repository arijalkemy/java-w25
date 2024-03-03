package Calorias.service;

import Calorias.dto.DtoPlato;
import Calorias.entity.Ingredientes;
import Calorias.entity.IngredientesPlato;
import Calorias.entity.Plato;
import Calorias.repository.IngredientesRepository;
import Calorias.repository.PlatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlatoService implements IPlatoService {

    @Autowired
    PlatosRepository platosRepository;
    @Autowired
    IIngredientesService ingredientesService;

    @Override
    public Plato exitsPlato(String plato) {
        List<Plato> platosRepo = platosRepository.allPlatos();
        return platosRepo.stream()
                .filter(p -> p.getNombre().equals(plato))
                .findFirst()
                .orElse(null);
    }

    @Override
    public DtoPlato addDtoPlato(String plato) {
        Plato platoFound = exitsPlato(plato);
        List<Ingredientes> ingredCal= new ArrayList<>();

        int acumuladorCalorias = 0;
        Ingredientes ingrMayorCal= new Ingredientes();
        if (platoFound !=null) {
            List<IngredientesPlato> listIngredientes = platoFound.getIngredientes();
            for (IngredientesPlato ingredientePlato : listIngredientes) {
                Ingredientes ingCocina = ingredientesService.findIngrediente(ingredientePlato);
                if (ingCocina!=null) {
                    acumuladorCalorias += ingCocina.getCalories() * ingredientePlato.getCatidad();
                    ingredCal.add(ingCocina);
                    if (ingCocina.getCalories()>ingrMayorCal.getCalories()){
                        ingrMayorCal=ingCocina;
                    }
                }
            }
        }
        DtoPlato platoCalorias = new DtoPlato(plato,acumuladorCalorias,ingredCal,ingrMayorCal);
        return platoCalorias;
    }

}
