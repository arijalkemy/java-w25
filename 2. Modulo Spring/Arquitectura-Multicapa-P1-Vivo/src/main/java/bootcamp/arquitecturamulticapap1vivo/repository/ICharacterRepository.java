package bootcamp.arquitecturamulticapap1vivo.repository;

import bootcamp.arquitecturamulticapap1vivo.entity.Character;

import java.util.List;

public interface ICharacterRepository {

    List<Character> getCharactersByName(String name);

}
