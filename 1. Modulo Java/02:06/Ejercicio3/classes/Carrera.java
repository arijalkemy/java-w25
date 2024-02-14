package classes;

import java.util.ArrayList;
import java.util.List;

public class Carrera implements ISocorristaAuto, ISocorristaMoto {
    private int cantidadVehiculosPermitidos;
    private int distancia;
    private double premioDolares;
    private String nombre;
    private List<Vehiculo> listaVehiculos;

    public Carrera(int cantidadVehiculosPermitidos, int distancia, double premioDolares, String nombre) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.listaVehiculos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Carrera [cantidadVehiculosPermitidos=" + cantidadVehiculosPermitidos + ", distancia=" + distancia
                + ", premioDolares=" + premioDolares + ", nombre=" + nombre + ", listaVehiculos=" + listaVehiculos
                + "]";
    }

    // 4
    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (cantidadVehiculosPermitidos > listaVehiculos.size()) {
            Vehiculo vehiculo = new Vehiculo(velocidad, aceleracion, 1000, 4, anguloDeGiro, patente);
            listaVehiculos.add(vehiculo);
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (cantidadVehiculosPermitidos > listaVehiculos.size()) {
            Vehiculo vehiculo = new Vehiculo(velocidad, aceleracion, 300, 2, anguloDeGiro, patente);
            listaVehiculos.add(vehiculo);
        }
    }

    // 5
    public void eliminarVehiculo(Vehiculo vehiculo) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getPatente() == vehiculo.getPatente()) {
                listaVehiculos.remove(i);
            }
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        for (int i = 0; i < listaVehiculos.size(); i++) {
            if (listaVehiculos.get(i).getPatente() == unaPatente) {
                listaVehiculos.remove(i);
            }
        }
    }

    // 6
    public void definirGanador() {
        double valorMaximo = 0;
        double valorActual = 0;
        for (int i = 0; i < listaVehiculos.size(); i++) {
            valorActual = listaVehiculos.get(i).getVelocidad() * listaVehiculos.get(i).getAceleracion()
                    / (listaVehiculos.get(i).getAnguloDeGiro()
                            * (listaVehiculos.get(i).getPeso() - listaVehiculos.get(i).getRuedas() * 100));
            if (valorActual > valorMaximo) {
                System.out.println("El ganador es: " + listaVehiculos.get(i).getPatente());
            }
        }
    }

    // 7
    @Override
    public void socorrerAuto(Vehiculo unAuto) {
        System.out.println("socorriendo auto: " + unAuto.getPatente());
    }

    @Override
    public void socorrerMoto(Vehiculo unaMoto) {
        System.out.println("socorriendo moto: " + unaMoto.getPatente());
    }

}
