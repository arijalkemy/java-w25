package org.example;

public class Main {
    public static void main(String[] args) {

            SocorristaAuto socorristaAuto = new SocorristaAuto();
            SocorristaMoto socorristaMoto = new SocorristaMoto();
            Carrera carrera = new Carrera(200, 100, "Formula 1", 4, socorristaAuto, socorristaMoto);
            carrera.darDeAltaAuto(20,10,90,"123");
            carrera.darDeAltaAuto(15,20,45,"200");
            carrera.darDeAltaMoto(10,2,28,"403");

            carrera.eliminarVehiculoConPatente("200");
            System.out.println("Ganador de la carrera: " + carrera.obtenerGanador());

            System.out.println();
            System.out.println("Socorrer");
            carrera.socorrerAuto("123");
            carrera.socorrerMoto("403");



    }
}