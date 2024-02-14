import Ejercicio1.classes.*;
import classes.PracticaExcepciones;

public class App {
    public static void main(String[] args) throws Exception {
        PracticaExcepciones pe1 = new PracticaExcepciones();

        try {
            pe1.calcularCociente();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
