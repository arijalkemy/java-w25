package com.example.CalculadoraCalorias.Repositories;
import com.example.CalculadoraCalorias.Models.Ingrediente;
import com.example.CalculadoraCalorias.Models.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class PlatosRepositoryImp implements IPlatosRepository{

    private  List<Plato> platoList = new ArrayList<>();

    IIngredientesRepository ingredientesRepository;
    public PlatosRepositoryImp(IngredientesRepositoryImp ingredientesRepository) {
        this.ingredientesRepository = ingredientesRepository;
        loadPlatos();
    }

    @Override
    public void loadPlatos() {
        platoList.add(new Plato("Changua",List.of(ingredientesRepository.findByName("Leche entera"), ingredientesRepository.findByName("Cebolla"))));
    }



}
