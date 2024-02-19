package com.main;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Carrera autosCarrera = new Carrera(150f,1000f,"Pista 1",5);
        autosCarrera.darDeAltaAuto(100f, 10f, 15f, "CAR001");
        autosCarrera.darDeAltaAuto(110f, 11f, 16f, "CAR002");
        autosCarrera.darDeAltaAuto(120f, 12f, 17f, "CAR003");
        autosCarrera.darDeAltaAuto(130f, 13f, 18f, "CAR004");

        Carrera motosCarrera = new Carrera(150f,1000f,"Pista 2",5);
        motosCarrera.darDeAltaMoto(80f, 8f, 20f, "MOTO001");
        motosCarrera.darDeAltaMoto(85f, 9f, 21f, "MOTO002");
        motosCarrera.darDeAltaMoto(90f, 10f, 22f, "MOTO003");
        motosCarrera.darDeAltaMoto(95f, 11f, 23f, "MOTO004");


        Vehiculo autoElim=new Auto(100f, 10f, 15f, "CAR001");

        autosCarrera.eliminarVehiculo(autoElim);
        motosCarrera.eliminarVehiculoConPatente("MOTO003");

        //System.out.println(autosCarrera);
        System.out.println("--- GANADOR ---");
        Vehiculo ganador = autosCarrera.obtenerGanador();
        System.out.println(ganador);

        Vehiculo sa1 = new SocorristaAuto(85, 9, 21, "MOT-SOC");
        Vehiculo sm1 = new SocorristaMoto(130f, 13f, 18f, "CAR-SOC");
        autosCarrera.darDeAltaAuto(100f, 12f, 23f, "SOCORRISTA-AUTO");
        motosCarrera.darDeAltaMoto(100f, 12f, 23f, "SOCORRISTA-MOTO");
        autosCarrera.socorrerAuto("CAR002");
        motosCarrera.socorrerMoto("MOTO003");

    }
}
