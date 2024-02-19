package com.main;

public class Inscripciones {
    private String categoria;
    private int numPart;
    private int monto;

    public Inscripciones(String categoria, int numPart, int monto) {
        this.categoria = categoria;
        this.numPart = numPart;
        this.monto = monto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumPart() {
        return numPart;
    }

    public void setNumPart(int numPart) {
        this.numPart = numPart;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Inscripciones{" +
                ", categoria='" + categoria + '\'' +
                ", numPart=" + numPart +
                ", monto=" + monto +
                '}';
    }
}
