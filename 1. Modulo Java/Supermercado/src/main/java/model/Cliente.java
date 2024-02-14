package model;

public class Cliente {

    private int dni;
    private String nombre;
    private String apellido;

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "model.Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    public int getDni() {
        return dni;
    }
}
