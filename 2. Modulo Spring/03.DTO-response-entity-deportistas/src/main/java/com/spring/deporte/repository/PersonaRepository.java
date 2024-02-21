package com.spring.deporte.repository;

import com.spring.deporte.entity.Deporte;
import com.spring.deporte.entity.Persona;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonaRepository {
    List<Persona> personas = new ArrayList<>() {{
        add(new Persona("juan", "perez", 23));
        add(new Persona("jacinta", "martinez", 45, new ArrayList<>() {{
            add(new Deporte("natacion", "easy"));
            add(new Deporte("basquet", "intermedio"));
        }} ));
        add(new Persona("pepita", "paez", 30, new ArrayList<>() {{
            add(new Deporte("voley", "easy"));
            add(new Deporte("natacion", "profesional"));
        }}));
    }};

    public List<Persona> todasLasPersonas(){
        return this.personas;
    }

    public List<Persona> deportistas(){
        return this.personas.stream()
                .filter(per -> !per.getDeportes().isEmpty())
                .toList();
    }
}
