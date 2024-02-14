package org.clase02_02_24.segunda_parte;

import java.util.List;

public class Garage {
    private Integer id;
    private List<Vehiculo> vehiculoList;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public Integer getId() {
        return id;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public Garage(Integer id, List<Vehiculo> vehiculoList) {
        this.id = id;
        this.vehiculoList = vehiculoList;
    }
}
