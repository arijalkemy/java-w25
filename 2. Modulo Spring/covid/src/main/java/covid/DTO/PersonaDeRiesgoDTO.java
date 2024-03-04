package covid.DTO;

import covid.Model.Sintoma;

import java.util.List;

public class PersonaDeRiesgoDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> listaSintomas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Sintoma> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(List<Sintoma> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }
}
