package Covid.service;

import Covid.models.Persona;
import Covid.models.Sintoma;

import java.util.List;

public class ServiceCovid {
    List<Persona> personasList;
    List<Sintoma> sintomasList;

    public ServiceCovid() {
        this.personasList = List.of(new Persona("123","Paula","Quintero",60),
                new Persona("456","Juan","Lopez",65),
                new Persona("789","Sara","Perez",28),
                new Persona("321","Diego","Sanchez",31));
        this.sintomasList = List.of(new Sintoma("000","Fiebre","bajo"),
                new Sintoma("001","Fatiga","medio"),
                new Sintoma("002","Dolores Musculares","alto"),
                new Sintoma("003","Dolor Cabeza","alto"),
                new Sintoma("004","Dificultad respirar","medio"));
    }


    public List<Persona> getPersonasList() {
        return personasList;
    }

    public List<Sintoma> getSintomasList() {
        return sintomasList;
    }
}
