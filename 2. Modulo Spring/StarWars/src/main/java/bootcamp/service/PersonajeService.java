package bootcamp.service;

import bootcamp.dto.PersonajeDTO;
import bootcamp.model.Personaje;
import bootcamp.repository.PersonajeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepo repo;
    public List<Personaje> findByName(String name){
        List<Personaje> lista =  repo.cargarJsonPersonajes().stream()
                .filter(personaje -> personaje.getName().toLowerCase().contains(name.toLowerCase())
                ).toList();
                return lista;

   }
}

