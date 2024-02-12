package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {
  private Double distancia;
  private Double premioDolares;
  private String nombre;
  private Integer cantVehiculo;
  private List<Vehiculo> listaVehiculos;
  private SocorristaAuto socorristaAuto;
  private SocorristaMoto socorristaMoto;

  public Carrera(Double distancia, Double premioDolares, String nombre, Integer cantVehiculo) {
    this.distancia = distancia;
    this.premioDolares = premioDolares;
    this.nombre = nombre;
    this.cantVehiculo = cantVehiculo;
    this.listaVehiculos = new ArrayList<>();
  }

  private Optional<Vehiculo> obtenerVehiculo(String patente) {
    return this.listaVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();
  }

  public void darDeAltaAuto(double velocidad,double aceleracion, double anguloDeGiro,String patente){
    if (this.listaVehiculos.size() == this.cantVehiculo) {
      System.out.println("Se han agotado los cupos disponibles");
      return;
    }

    listaVehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
  }

  public void darDeAltaMoto(double velocidad,double aceleracion, double anguloDeGiro,String patente){
    if (this.listaVehiculos.size() == this.cantVehiculo) {
      System.out.println("Se han agotado los cupos disponibles");
      return;
    }

    listaVehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
  }

  public void eliminarVehiculo(Vehiculo vehiculo){
    listaVehiculos.remove(vehiculo);
  }

  public void eliminarVehiculoPatente(String patente){
    listaVehiculos.removeIf(v -> v.getPatente().equals(patente));
  }

  public void socorrerAuto(String patente) {
    Optional<Vehiculo> auto = this.obtenerVehiculo(patente);

    if (auto.isEmpty()) {
      System.out.println("La patente no existe...");
      return;
    }

    this.socorristaAuto.socorrer((Auto) auto.get());
  }

  public void socorrerMoto(String patente) {
    Optional<Vehiculo> moto = this.obtenerVehiculo(patente);

    if (moto.isEmpty()) {
      System.out.println("La patente no existe...");
      return;
    }

    this.socorristaAuto.socorrer((Auto) moto.get());
  }
}
