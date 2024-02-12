package bootcamp.recapitulacion;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Garage {
    private int idGarage;
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Garage(int idGarage) {
        this.idGarage = idGarage;
    }
}
