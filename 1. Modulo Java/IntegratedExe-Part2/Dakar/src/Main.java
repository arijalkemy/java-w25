public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(1.5,30000,"La Carrera ",3);
        carrera.darDeAltaCarro(100.0,50.0,180.0,"LXG567");
        carrera.darDeAltaMoto(300.0,100.0,200.0,"LX58B");
        carrera.darDeAltaCarro(125.2, 62.0, 34.0, "SHY345");
        carrera.darDeAltaMoto(567.8, 56.5, 123.9, "DF56J");
        System.out.println("--------------------------------------------");
        carrera.eliminarVehiculo("LXG567");
        System.out.println(carrera.obtenerGanador());
    }
}