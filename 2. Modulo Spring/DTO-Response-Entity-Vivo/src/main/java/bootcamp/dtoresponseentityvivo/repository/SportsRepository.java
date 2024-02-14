package bootcamp.dtoresponseentityvivo.repository;

import bootcamp.dtoresponseentityvivo.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class SportsRepository {
    List<Sport> sports = Arrays.asList(
            new Sport("Fútbol", "Básico"),
            new Sport("Tenis", "Avanzado"),
            new Sport("Rugby", "Básico"),
            new Sport("Voley", "Básico"),
            new Sport("Basket", "Básico"),
            new Sport("Handbol", "Intermedio"),
            new Sport("Natación", "Intermedio")
    );

    public List<Sport> getSports() {
        return sports;
    }

}
