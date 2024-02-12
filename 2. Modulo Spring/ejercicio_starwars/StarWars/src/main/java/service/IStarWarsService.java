package service;


import dto.PersonajeDTO;
import java.util.List;

public interface IStarWarsService {
    List<PersonajeDTO> searchCharacter(String query);
}
