package com.example.CalculadoraDeCalorias.service;

import com.example.CalculadoraDeCalorias.dto.response.CalculadoraDTO;
import com.example.CalculadoraDeCalorias.entity.Ingrediente;
import com.example.CalculadoraDeCalorias.entity.Plato;
import com.example.CalculadoraDeCalorias.repository.IIngredienteRepository;
import com.example.CalculadoraDeCalorias.repository.IPlatoRepository;
import com.example.CalculadoraDeCalorias.repository.IngredienteRepositoryImp;
import com.example.CalculadoraDeCalorias.repository.PlatoRepositoryImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoServiceImp implements IPlatoService {

    private IPlatoRepository platoRepository;
    private IIngredienteRepository ingredienteRepository;

    public PlatoServiceImp(PlatoRepositoryImp platoRepository, IngredienteRepositoryImp ingredienteRepository) {
        this.platoRepository = platoRepository;
        this.ingredienteRepository = ingredienteRepository;
    }

    @Override
    public CalculadoraDTO calcular(String name, int peso) {
        Plato plato = platoRepository.getPlatoByName(name);

        Ingrediente ingredienteMax = new Ingrediente();
        ingredienteMax.setCalorias(0);

        List<String> ingredientes = new ArrayList<>();
        int calorias = 0;
        for (String ing:plato.getIngredientes()) {
            Ingrediente ingrediente = ingredienteRepository.getIngredienteByName(ing);
            ingredientes.add(ingrediente.getNombre());
            int caloriasIng = ingrediente.getCalorias();

            calorias += caloriasIng;
            if (caloriasIng > ingredienteMax.getCalorias()) {
                ingredienteMax.setCalorias(caloriasIng);
                ingredienteMax.setNombre(ingrediente.getNombre());
            }
        }


        CalculadoraDTO response = new CalculadoraDTO();
        response.setCaloriasTotales(calorias*(peso/100.0));
        response.setListaDeIngredientes(ingredientes);
        response.setIngredienteMasCalorico(ingredienteMax.getNombre());

        return response;
    }
}
