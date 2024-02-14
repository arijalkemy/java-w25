package bootcamp;

import bootcamp.domain.PracticaExcepciones;

public class Main
{
    public static void main( String[] args )
    {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones(0, 300);
        try {
            practicaExcepciones.calcularCociente();
        } catch (ArithmeticException e) {
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
