package main;

import java.util.List;

public class Garaje {

    private String id;
    private List<Vehiculo> vehiculoList;

    @Override
    public String toString() {
        return "Garaje{" +
                "id='" + id + '\'' +
                ", vehiculoList=" + vehiculoList +
                '}';
    }

    public Garaje(String id, List<Vehiculo> vehiculoList) {
        this.id = id;
        this.vehiculoList = vehiculoList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }
}
