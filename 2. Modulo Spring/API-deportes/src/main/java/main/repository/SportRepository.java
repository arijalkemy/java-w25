package main.repository;

import main.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SportRepository {

    List<Sport> sportList = new ArrayList<>();

    public SportRepository (){
        sportList.add(new Sport("Futbol", "Profesional"));
        sportList.add(new Sport("Tenis", "Profesional"));
        sportList.add(new Sport("Baloncesto", "Profesional"));
    }

    public List<Sport> findAll() {
        return sportList;
    }

    public Optional<Sport> findSportByName(String nombre){
        return sportList.stream().filter(x -> x.getName().equalsIgnoreCase(nombre)).findFirst();
    }
}
