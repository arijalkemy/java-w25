package org.bootcamp.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bootcamp.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Repository
public class PersonajeRepository Oimplements IPersonajeRepository {

    List<Personaje> personajes = new ArrayList<>();

    @Override
    public void leerPersonajesDesdeJson(String rutaArchivo) {
        ObjectMapper objectMapper = new ObjectMapper();
        this.personajes = new ArrayList<>();
        try {
            this.personajes = objectMapper.readValue(new File(rutaArchivo), new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            System.out.println("No es posible leer el archivo JSON " + e);
        }
    }

}
