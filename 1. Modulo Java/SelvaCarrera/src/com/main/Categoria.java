package com.main;
import java.util.Arrays;

public class Categoria {
    private int kilometros;
    private String[] terreno;

    public Categoria(int kilometros, String[] terreno) {
        this.kilometros = kilometros;
        this.terreno = terreno;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public String[] getTerreno() {
        return terreno;
    }

    public void setTerreno(String[] terreno) {
        this.terreno = terreno;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "kilometros=" + kilometros +
                ", terreno=" + Arrays.toString(terreno) +
                '}';
    }
}
