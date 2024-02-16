package org.example.impresora;

import java.util.ArrayList;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Curriculum extends Documento{
    String nombre;
    String email;
    ArrayList<String> habilidades;

    public Curriculum(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.habilidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void nuevaHabilidad(String habilidad) {
        this.habilidades.add(habilidad);
    }

    @Override
    public String toString() {
        return "Curriculum [nombre=" + nombre + ", email=" + email + ", habilidades=" + habilidades
                + "]";
    }
}
