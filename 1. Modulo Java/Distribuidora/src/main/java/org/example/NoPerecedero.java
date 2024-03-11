package org.example;

public class NoPerecedero extends Producto{
    private String tipo;

    public NoPerecedero() {
    }

    public NoPerecedero(String nombre, Double precio) {
        super(nombre, precio);
    }

    public NoPerecedero(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nombre, Double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
