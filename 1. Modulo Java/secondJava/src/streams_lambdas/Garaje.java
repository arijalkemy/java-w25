package streams_lambdas;

import java.util.ArrayList;

public class Garaje {
    private String id;
    private ArrayList<Vehiculo> vehiculos;

    public Garaje(String id, ArrayList<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
}
