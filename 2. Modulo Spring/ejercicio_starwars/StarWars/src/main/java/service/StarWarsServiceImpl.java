package service;

import dto.PersonajeDTO;
import entity.Personaje;
import org.springframework.stereotype.Service;
import repository.StarWarsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsServiceImpl implements IStarWarsService{
    StarWarsRepository repository = new StarWarsRepository();
    @Override
    public List<PersonajeDTO> searchCharacter(String nombre){
        List<Personaje> personajesList = repository.getPersonajes();
        personajesList = personajesList.stream().filter(x -> x.getName().toUpperCase().contains(nombre.toUpperCase())).toList();

        List<PersonajeDTO> personajeDTOList = new ArrayList<>();

        personajesList.forEach(personaje ->
                personajeDTOList.add(new PersonajeDTO(personaje.getName(),
                        personaje.getHeight(),
                        personaje.getMass(),
                        personaje.getGender(),
                        personaje.getHomeworld(),
                        personaje.getSpecies())));

        return personajeDTOList;
    }
}
