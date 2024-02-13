package com.example.calculadora_calorias.service.impl;

import com.example.calculadora_calorias.dto.CaloriasRecetaDto;
import com.example.calculadora_calorias.dto.IngredientesCaloria;
import com.example.calculadora_calorias.dto.PlatosWrapperDto;
import com.example.calculadora_calorias.dto.RecetaIngredientesCalorias;
import com.example.calculadora_calorias.entity.Ingrediente;
import com.example.calculadora_calorias.entity.IngredienteReceta;
import com.example.calculadora_calorias.entity.Receta;
import com.example.calculadora_calorias.repository.IngredientesRepository;
import com.example.calculadora_calorias.repository.RecetaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecetasService implements IRecetasService {


    private RecetaRepository recetaRepository;
    private IngredientesRepository ingredientesRepository;

    public RecetasService(RecetaRepository recetaRepository, IngredientesRepository ingredientesRepository) {
        this.recetaRepository = recetaRepository;
        this.ingredientesRepository = ingredientesRepository;
    }

    @Override
    public CaloriasRecetaDto caloriasPlato(String plato) {
        Optional<Receta> existe = findReceta(plato);

        int acumuladorCalorias = 0;

        if (existe.isPresent()) {

            for (IngredienteReceta ingrediente : existe.get().getIngredientesReceta()) {
                Optional<Ingrediente> ingredienteOptional = ingredientesRepository.findIngrediente(ingrediente.getIngrediente());
                if (ingredienteOptional.isPresent()) {
                    acumuladorCalorias += ingredienteOptional.get().getCalories() * ingrediente.getPorciones();
                }
            }

        }
        return new CaloriasRecetaDto(existe.get().getNombre(),acumuladorCalorias);
    }



    
    @Override
    public List<RecetaIngredientesCalorias> detallesRecetas(PlatosWrapperDto platos) {
        List<RecetaIngredientesCalorias> recetasCalorias = new ArrayList<>();

        if (!platos.getPlatos().isEmpty()){

            for (String receta:platos.getPlatos()) {

                recetasCalorias.add(getDetalleReceta(receta));

            }

            return recetasCalorias;
        }

        return null;


    }

    @Override
    public RecetaIngredientesCalorias getDetalleReceta(String receta) {
        Optional<Receta> existe = findReceta(receta);

        if (existe.isPresent()){
            List<IngredientesCaloria> ingredientesCalorias = new ArrayList<>();
            for (IngredienteReceta ingrediente : existe.get().getIngredientesReceta()) {
                Optional<Ingrediente> ingredienteOptional = ingredientesRepository.findIngrediente(ingrediente.getIngrediente());
                if (ingredienteOptional.isPresent()) {

                    ingredientesCalorias.add(new IngredientesCaloria(ingredienteOptional.get().getName(),ingredienteOptional.get().getCalories()*ingrediente.getPorciones()));

                }
            }


            return new RecetaIngredientesCalorias(existe.get().getNombre(),ingredientesCalorias,caloriasPlato(receta).getCalorias());
        }

        return null;
    }

    @Override
    public String ingredienteMasCalorias(String receta) {
        Optional<Receta> existe = findReceta(receta);


        int mayorCalorias = 0;
        String ingredienteMasCalorico = "";

        if (existe.isPresent()) {

            for (IngredienteReceta ingrediente : existe.get().getIngredientesReceta()) {
                Optional<Ingrediente> ingredienteOptional = ingredientesRepository.findIngrediente(ingrediente.getIngrediente());
                if (ingredienteOptional.isPresent()) {

                    if (mayorCalorias < ingredienteOptional.get().getCalories() * ingrediente.getPorciones()){
                        mayorCalorias = ingredienteOptional.get().getCalories() * ingrediente.getPorciones();
                        ingredienteMasCalorico = ingredienteOptional.get().getName();
                    }

                }
            }
            return ingredienteMasCalorico;

        }
        return "No existe";

    }

    @Override
    public Optional<Receta> findReceta(String plato) {
        return recetaRepository.getRecetas()
                .stream()
                .filter(receta -> receta.getNombre().toLowerCase().contains(plato.toLowerCase()))
                .findFirst();
    }
}
