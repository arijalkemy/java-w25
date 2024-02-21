package main.java.com.bootcamp.model;

public class Cliente {
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '/' +
                '}';
    }
}
