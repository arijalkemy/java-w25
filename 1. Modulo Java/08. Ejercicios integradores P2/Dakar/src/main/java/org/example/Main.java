package org.example;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1.5,30000,"La Carrera ",2);
        Vehiculo moto = new Moto(3000,500,180,"LX58B");
        Vehiculo carro = new Carro(3000,500,180,"LX58B");
        carrera.darDeAltaVehiculo(moto);
        carrera.darDeAltaVehiculo(carro);
        carrera.imprimirLista();

    }
}