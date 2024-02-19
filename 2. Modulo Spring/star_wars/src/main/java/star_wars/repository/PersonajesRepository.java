package star_wars.repository;

import star_wars.entity.Personaje;

import java.util.List;

public interface PersonajesRepository {
    public void readPersonajes(String filePath);

    public List<Personaje> getPersonajes();

    public void personajesFix();
}
