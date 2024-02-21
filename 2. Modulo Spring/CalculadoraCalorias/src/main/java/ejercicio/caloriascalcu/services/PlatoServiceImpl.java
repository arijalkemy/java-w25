package ejercicio.caloriascalcu.services;

import ejercicio.caloriascalcu.entity.Ingrediente;
import ejercicio.caloriascalcu.entity.Plato;
import ejercicio.caloriascalcu.repository.IngredienteRepository;
import ejercicio.caloriascalcu.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServiceImpl implements IPlatoServices{
    @Autowired
    PlatoRepository platoRepository;
    IngredienteRepository ingredienteRepository;
    public Double getPlatoCalorias(String nombreDePlato){
        List<Plato> platos = platoRepository.getPlatos();
        Plato platoRequerido = platos.stream().filter(plato -> plato.getNombre().equals((nombreDePlato)))
                .toList().getFirst();
        platoRequerido.getCantidadesIngredientes().forEach(ingre)
    }




}
