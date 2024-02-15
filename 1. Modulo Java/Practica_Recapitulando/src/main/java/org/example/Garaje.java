package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculosList = new ArrayList<>();

    public Garaje(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculosList() {
        return vehiculosList;
    }

    public void setVehiculosList(List<Vehiculo> vehiculosList) {
        this.vehiculosList = vehiculosList;
    }
}
