package ejercicio.starwars.service;

import ejercicio.starwars.entity.Personaje;
import ejercicio.starwars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    private final PersonajeRepository pjRepo;

    public PersonajeService(PersonajeRepository pjRepo){
        this.pjRepo = pjRepo;
    }

    public Iterable<Personaje> list() {
        return pjRepo.findAll();
    }

    public Iterable<Personaje> save(List<Personaje> personajes) {
        return pjRepo.save(personajes);
    }
}
