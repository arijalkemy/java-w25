package org.example;

import org.example.dakar.Carrera;
import org.example.savetheropa.GuardaRopa;
import org.example.savetheropa.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        dakar();
    }
    private static void dakar(){
        Carrera carrera = new Carrera(100, 1000, "Carreraa", 3);
        carrera.darDeAltaAuto(100, 50, 10, "1234");
        carrera.darDeAltaAuto(150, 60, 10, "4321");
        carrera.darDeAltaMoto(180, 66, 8, "1221");
        carrera.eliminarVehiculoPorPatente("4321");
        carrera.darDeAltaAuto(42, 31, 43, "1123");
        carrera.socorrerCarro("1123");
        carrera.socorrerMoto("1221");
        carrera.definirGanador();
    }
}