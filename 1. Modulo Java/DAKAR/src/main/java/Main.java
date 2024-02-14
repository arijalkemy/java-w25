public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000, 1000000, "Nascar", 5);
        carrera.darDeAltaAuto(200, 30, 10, "ABC123");
        carrera.darDeAltaMoto(120, 30, 120, "DEF456");
        carrera.darDeAltaAuto(120, 30, 120, "GHI789");
        carrera.darDeAltaMoto(150, 40, 10, "JKL012");
        carrera.darDeAltaAuto(120, 30, 120, "MNO345");
        carrera.darDeAltaMoto(120, 30, 120, "PQR678");

        carrera.eliminarVehiculoConPatente("MNO345");
        carrera.getListaDeVehiculos().forEach(System.out::println);

        Vehiculo ganador = carrera.definirGanador();
        System.out.println("El ganador es: " + ganador.getPatente());
    }
}
