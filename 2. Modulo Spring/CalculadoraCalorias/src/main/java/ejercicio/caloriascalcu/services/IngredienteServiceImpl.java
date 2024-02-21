package ejercicio.caloriascalcu.services;

import ejercicio.caloriascalcu.entity.Ingrediente;
import ejercicio.caloriascalcu.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.DoubleBuffer;
import java.util.List;

@Service
public class IngredienteServiceImpl implements IIngredienteService{
    @Autowired
    IngredienteRepository ingredienteRepository;

    public List<Ingrediente> getAll(){
        ingredienteRepository.leerIngredientesJson();
        return ingredienteRepository.getIngredientes();
    }



}
