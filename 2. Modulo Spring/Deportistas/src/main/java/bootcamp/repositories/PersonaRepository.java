package bootcamp.repositories;

import bootcamp.models.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonaRepository {

    public static List<Persona> listaPersonas = Arrays.asList(
            new Persona("Juan", "Perez", 25, DeporteRepository.listaDeporte.get(0)),
            new Persona("Martin", "Sanchez", 32, DeporteRepository.listaDeporte.get(0)),
            new Persona("Pedro", "Gimenez", 13, DeporteRepository.listaDeporte.get(1)),
            new Persona("Jaime", "Lopez", 20, DeporteRepository.listaDeporte.get(3))

    );

}
