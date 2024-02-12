package bootcamp.poo2;

public class Ejercicio1 {
    public static void main(String[] args) {
        PracticaExcepciones practicaExcepciones= new PracticaExcepciones();
        practicaExcepciones.showDivAB();
        try {
            practicaExcepciones.showDivABV2();
        }
        catch (IllegalArgumentException ex){
            System.out.println("ex = " + ex.getMessage());
        }


        practicaExcepciones.setA(1);
        practicaExcepciones.showDivAB();
    }
}
