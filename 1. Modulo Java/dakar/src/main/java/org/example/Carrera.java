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
    return this.listaVehiculos.stream().findFirst();
  }

  public void darDeAltaAuto(double velocidad,double aceleracion, double anguloDeGiro,String patente){
    if (this.listaVehiculos.size() < this.cantVehiculo){
      //agrego
      Vehiculo vehiculo = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
      listaVehiculos.add(vehiculo);
    }else{
      System.out.println("Se han agotado los cupos disponibles");
    }
  };


  public void eliminarVehiculo(Vehiculo vehiculo){
    listaVehiculos.remove(vehiculo);
  }

  public void eliminarVehiculoPatente(String patente){
      for (Vehiculo i: listaVehiculos){
        if (i.getPatente().equals(patente)){
          listaVehiculos.remove(i);
        }
      }
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
  public Vehiculo ganador(){
    return listaVehiculos.stream().max((x,y) -> {
      double primer = x.getVelocidad()*0.5*(x.getAceleracion()/x.getAnguloGiro()*(x.getPeso()-x.getRuedas()*100));
      double segun = y.getVelocidad()*0.5*(y.getAceleracion()/y.getAnguloGiro()*(y.getPeso()-y.getRuedas()*100));
      if (primer > segun){
        return 1;
      } else if (primer == segun) {
        return 0;
      } else{
        return -1;
      }
    }).get();
  }
}
