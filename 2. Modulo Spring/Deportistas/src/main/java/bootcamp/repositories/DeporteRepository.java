package bootcamp.repositories;

import bootcamp.models.Deporte;

import java.util.Arrays;
import java.util.List;

public class DeporteRepository {

    public static List<Deporte> listaDeporte = Arrays.asList(
            new Deporte("Futbol", "Medio"),
            new Deporte("Basquet", "Medio"),
            new Deporte("Voley", "Alto"),
            new Deporte("Esgrima", "Muy Alto")

    );


}
