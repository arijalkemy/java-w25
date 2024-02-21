package Ejercicio_Vehiculos;

import java.util.List;

public class Garage {
    private int id;
    List<Vehiculo> listaCoches;

    public Garage(int id, List<Vehiculo> listaCoches) {
        this.id = id;
        this.listaCoches = listaCoches;
    }

    public void agregarCoche(Vehiculo coche) {
        this.listaCoches.add(coche);
    }
}
