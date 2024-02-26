package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private static int cantGaraje = 0;
    private int id;
    private List<Vehiculo> listaVehiculo;

    public Garaje( List<Vehiculo> listaVehiculo) {
        cantGaraje += 1;
        this.id = cantGaraje;
        this.listaVehiculo = listaVehiculo;
    }

    public Garaje(){
        cantGaraje += 1;
        this.id =cantGaraje;
        this.listaVehiculo = new ArrayList<>();
    }

    public static int getCantGaraje() {
        return cantGaraje;
    }

    public static void setCantGaraje(int cantGaraje) {
        Garaje.cantGaraje = cantGaraje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public void addVehiculo(Vehiculo v){
        this.listaVehiculo.add(v);
    }
}
