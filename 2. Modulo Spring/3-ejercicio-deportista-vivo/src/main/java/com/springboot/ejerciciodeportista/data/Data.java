package com.springboot.ejerciciodeportista.data;

import com.springboot.ejerciciodeportista.entity.Deporte;
import com.springboot.ejerciciodeportista.entity.Persona;

import java.util.List;

public class Data {
    public static List<Deporte> getDeportes() {
        return List.of(
                new Deporte("CrossFit", "Advanced"),
                new Deporte("Rugby", "Amateur"),
                new Deporte("Soccer", "Middle")
        );
    }

    public static List<Persona> getPersonas() {
        return List.of(
                new Persona("Nicolás", "Aimar", 28, new Deporte("CrossFit", "Advanced")),
                new Persona("John", "Doe", 30, new Deporte("Rugby", "Amateur")),
                new Persona("Juan", "Pérez", 20, new Deporte("Soccer", "Middle"))
        );
    }
}
