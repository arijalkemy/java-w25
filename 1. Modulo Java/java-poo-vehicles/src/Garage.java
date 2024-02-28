import java.util.List;

public class Garage {
    private Long id;
    private List<Vehicle> vehicles;

    public Garage(Long id, List<Vehicle> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

}
