package bootcamp.arquitecturamulticapap1vivo.service;

import bootcamp.arquitecturamulticapap1vivo.dto.CharacterDto;

import java.util.List;

public interface ICharacterService {

    List<CharacterDto> getCharactersByName(String name);

}
