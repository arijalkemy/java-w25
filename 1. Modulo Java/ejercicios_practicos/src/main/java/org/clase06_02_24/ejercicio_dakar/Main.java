package org.clase06_02_24.ejercicio_dakar;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo v1 = new Moto(100,1000,23,"carlos");
        Vehiculo v2 = new Auto(100,1400,10,"god");

        Carrera car1 = new Carrera(3000,12000,"dakar",3, Arrays.asList(v1,v2));

        System.out.println(car1.obtenerGanador());
    }

}
