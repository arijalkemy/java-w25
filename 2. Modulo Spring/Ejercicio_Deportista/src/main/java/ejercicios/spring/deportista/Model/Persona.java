package ejercicios.spring.deportista.Model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Persona {
    String nombre;
    int edad;
    Deporte deporte;

    public Persona(String nombre, int edad, Deporte deporte) {
        this.nombre = nombre;
        this.edad = edad;
        this.deporte = deporte;
    }

    public String getNombreDeporte() {
        return deporte.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }
}
