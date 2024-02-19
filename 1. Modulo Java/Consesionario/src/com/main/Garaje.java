package com.main;
import java.util.ArrayList;

public class Garaje {
    private int id;
    ArrayList<Vehiculo> vehiculos;

    /*public Garaje(int id) {
        this.id = id;
        this.vehiculos = new ArrayList<Vehiculo>();
    }
     */

    public Garaje(int id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
