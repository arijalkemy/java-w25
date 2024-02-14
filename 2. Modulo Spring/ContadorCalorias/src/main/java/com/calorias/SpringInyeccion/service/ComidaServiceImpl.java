package com.calorias.SpringInyeccion.service;

import com.calorias.SpringInyeccion.DTO.ComidaDTO;
import com.calorias.SpringInyeccion.model.Ingrediente;
import com.calorias.SpringInyeccion.model.Plato;
import com.calorias.SpringInyeccion.repository.ComidaRepository;
import com.calorias.SpringInyeccion.repository.PlatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComidaServiceImpl implements IComidaService{

    @Autowired
    ComidaRepository comidaRepository;
    @Autowired
    PlatosRepository platosRepository;


    @Override
    public ComidaDTO obtenerIngredientes(List<String> platos){
        //TODO: Add lista con los platos y consultar los ingredientes. Retornar una lista de comidaDTO.

        List<Plato> platosObj = new ArrayList<>();
        for (String plato:
             platos) {
            platosObj.add(platosRepository.obtenerIngrediente(plato));
        }

        //TODO: obtener los platos dado el nombre, obtener de los platos los objetos de ingrediente
        // hacer los calculos y cambiar el return.
        List<Ingrediente> ingredientesDB = comidaRepository.obtenerIngredientes();

        List<List<String>> ingredientesPlatos = new ArrayList<>();
        platosObj.forEach(
                plato -> ingredientesPlatos.add(plato.getIngredientes())
        );
        List<Ingrediente> ingredientesObj = new ArrayList<>();

        Integer totalCalorias = 0;
        Ingrediente ingredienteMaxCalorias = new Ingrediente();
        ingredienteMaxCalorias.setCalories(0);
        for(Ingrediente ingrediente : ingredientesDB){
            for(List<String> ing: ingredientesPlatos)
            {
                if(ing.contains(ingrediente.getName())){
                    ingredientesObj.add(ingrediente);
                    totalCalorias+= ingrediente.getCalories();
                    if(ingrediente.getCalories()>ingredienteMaxCalorias.getCalories()){
                        ingredienteMaxCalorias = ingrediente;
                    }
                }
            }
        }

        return new ComidaDTO(totalCalorias, ingredientesObj,ingredienteMaxCalorias);
    }
}
