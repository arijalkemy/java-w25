package bootcamp.arquitecturamulticapap1vivo.service;

import bootcamp.arquitecturamulticapap1vivo.dto.CharacterDto;
import bootcamp.arquitecturamulticapap1vivo.entity.Character;
import bootcamp.arquitecturamulticapap1vivo.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImp implements ICharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<CharacterDto> getCharactersByName(String name) {
        List<Character> characters = characterRepository.getCharactersByName(name);
        List<CharacterDto> characterDtos = new ArrayList<>();

        for (Character character : characters) {
            CharacterDto characterDto = CharacterDto.builder()
                    .name(character.getName())
                    .height(character.getHeight())
                    .mass(character.getMass())
                    .gender(character.getGender())
                    .homeworld(character.getHomeworld())
                    .species(character.getSpecies())
                    .build();
            characterDtos.add(characterDto);
        }

        return characterDtos;
    }

}
