public class Main {
    public static void main(String[] args) {
        Vehiculo auto1 = new Vehiculo(
                100.0,
                100.0,
                45.0,
                "KDA-258",
                4,
                100
        ) {
        };

        Carrera carrera1 = new Carrera(
                250.0,
                10000,
                "Carrera de Dakar",
                15
        );

        carrera1.darDeAltaAuto(150.0, 120.0, 45.0, "TES-T21");
        carrera1.darDeAltaAuto(130.0, 120.0, 90.0, "PAD-T22");

        carrera1.darDeAltaMoto(210.0, 140.0, 75.0, "PAW-W14");
        carrera1.darDeAltaMoto(150.0, 95.0, 90.0, "KUT-211");

        carrera1.socorrerAuto("TES-T21");
        carrera1.socorrerMoto("KUT-211");

        carrera1.eliminarVehiculoConPatente("KUT-211");
        carrera1.socorrerMoto("KUT-211");
    }
    }
