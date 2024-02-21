package org.example.dakar.dominio;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Builder
public class Carrera {

    double distancia;
    double premioEnDolares;
    String nombre;
    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos = new ArrayList<>();
    SocorristaMoto socorrerMoto;
    SocorristaAuto socorrerAuto;

    public void socorrerAuto(String patente){
        Optional<Vehiculo> vehiculo = encontrarPatente(patente);
        if(vehiculo.isPresent())
            this.socorrerAuto.socorrer((Auto) vehiculo.get());
        else
            System.out.println("No se encontró el auto");

    }

    public void socorrerMoto(String patente){
        Optional<Vehiculo> vehiculo = encontrarPatente(patente);
        if(vehiculo.isPresent())
            this.socorrerMoto.socorrer((Moto) vehiculo.get());
        else
            System.out.println("No se encontró el moto");
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos)
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        else System.out.println("No hay mas cupos disponibles para esta carrera");
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos)
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        else System.out.println("No hay mas cupos disponibles para esta carrera");
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        if (!listaDeVehiculos.remove(vehiculo)) System.out.println("El vehículo no se encontraba enlistado");
    }

    public void eliminarVehiculoConPatente(String patente){
        this.listaDeVehiculos = listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente)).collect(Collectors.toList());
    }

    public Optional<Vehiculo> ganador(){
        return this.listaDeVehiculos.stream()
                                    .sorted(Comparator.comparing(vehi -> calcularPrioridad(vehi)))
                                    .findFirst();
    }

    private Optional<Vehiculo> encontrarPatente(String patente){
        return listaDeVehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst();
    }

    private double calcularPrioridad(Vehiculo vehi){
        // Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        return vehi.getVelocidad() * 1/2 * vehi.getAceleracion() / (vehi.getAnguloDeGiro()*(vehi.getPeso() - vehi.getRuedas()*100));
    }


}
