package covid.Model;

import java.util.List;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    //private List<Sintoma> listaSintomas;

    public Persona(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
       // this.listaSintomas = listaSintomas;
    }

    /*public List<Sintoma> getListaSintomas() {
        return listaSintomas;
    }

    public void setListaSintomas(List<Sintoma> listaSintomas) {
        this.listaSintomas = listaSintomas;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
}
