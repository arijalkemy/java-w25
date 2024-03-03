package EjercicioDeportistas.service;

import EjercicioDeportistas.models.Deporte;
import EjercicioDeportistas.models.Persona;

import java.util.List;

public class DeporteService {
    private List<Deporte> deportesList;
    private List<Persona> personasList;

    public DeporteService() {
        this.deportesList = List.of(new Deporte("Natacion","basico"),
                new Deporte("Basquetbol","intermedio"),
                new Deporte("Patinaje","avanzado"),
                new Deporte("Baile","basico"),
                new Deporte("Voleibol","intermedio"),
                new Deporte("Futbol","avanzado"));
        this.personasList = List.of(new Persona("Sara","Zapata",20),
                new Persona("Paula","Quintero",28),
                new Persona("Juan","Lopez",31),
                new Persona("Sara","Perez",28),
                new Persona("Diego","Sanchez",31));
    }

    public List<Deporte> getDeportesList() {
        return deportesList;
    }

    public List<Persona> getPersonasList() {
        return personasList;
    }
}
