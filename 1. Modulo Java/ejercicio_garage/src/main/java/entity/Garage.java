package entity;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int id;
    private List<Vehicle> vehicles;

    public Garage(int id) {
        this.id = id;
        this.vehicles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
