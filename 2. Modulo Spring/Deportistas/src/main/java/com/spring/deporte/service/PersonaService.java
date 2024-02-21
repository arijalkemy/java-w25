package com.spring.deporte.service;

import com.spring.deporte.domain.Deporte;
import com.spring.deporte.domain.Persona;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonaService {

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
