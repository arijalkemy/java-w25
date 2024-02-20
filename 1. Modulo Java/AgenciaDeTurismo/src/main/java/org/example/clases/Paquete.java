package org.example.clases;

public abstract class Paquete {
    int id;
    double costo;

    public Paquete() {
    }

    public Paquete(int id, double costo) {
        this.id = id;
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
