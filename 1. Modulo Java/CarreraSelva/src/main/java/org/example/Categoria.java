package org.example;


public class Categoria {

    private int id;
    private String tipo;

    private Double Precio;

    public String Categoria(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
