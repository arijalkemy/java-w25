package com.bootcamp.Calorias.service;

import com.bootcamp.Calorias.dto.request.RequestCaloriasDTO;
import com.bootcamp.Calorias.dto.response.IngredienteDTO;
import com.bootcamp.Calorias.dto.response.ResponseCaloriasDTO;
import com.bootcamp.Calorias.entity.IngredientexPlato;
import com.bootcamp.Calorias.repository.CaloriasRepositoryImpl;
import com.bootcamp.Calorias.repository.ICaloriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.Calorias.entity.Plato;

@Service
public class CaloriasService implements ICaloriasService{
    private ICaloriasRepository caloriasRepository;
    public CaloriasService(CaloriasRepositoryImpl caloriasRepository){
        this.caloriasRepository = caloriasRepository;
    }

    public ResponseCaloriasDTO getCalorias(RequestCaloriasDTO request) {
        Optional<Plato> plato = this.caloriasRepository.getPlatoByName(request.getName());

        if (plato.isPresent()){
            Plato platoFounded = plato.get();
            int mayorCaloria = platoFounded.getListaIngredientes().stream().mapToInt(IngredientexPlato::getCaloriasTotales).max().getAsInt();
            String ingredienteMayor = platoFounded.getListaIngredientes().stream().filter(ingredientexPlato -> ingredientexPlato.getCaloriasTotales() == mayorCaloria).findFirst().get().getIngrediente().getName();
            return new ResponseCaloriasDTO(platoFounded.getTotalCalorias(), platoFounded.getListaIngredientes().stream().map(i -> new IngredienteDTO(i.getIngrediente().getName(), i.getCaloriasTotales())).toList(),ingredienteMayor);
        }

        return null;
    }

    @Override
    public List<ResponseCaloriasDTO> getCaloriasVarias(List<RequestCaloriasDTO> platos) {
        return platos.stream().map(this::getCalorias).toList();
    }


}
