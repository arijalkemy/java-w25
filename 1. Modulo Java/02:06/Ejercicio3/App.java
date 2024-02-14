
import classes.*;

public class App {
        public static void main(String[] args) throws Exception {

                Carrera carrera1 = new Carrera(10, 500, 100000, "Carrera #1");
                carrera1.darDeAltaAuto(30, 20, 20, "AA 111 AA");
                carrera1.darDeAltaAuto(30, 20, 20, "bb 111 AA");
                carrera1.darDeAltaMoto(30, 20, 20, "BB 222 BB");

                carrera1.eliminarVehiculoConPatente("bb 111 AA");
                System.out.println(carrera1);
        }
}
