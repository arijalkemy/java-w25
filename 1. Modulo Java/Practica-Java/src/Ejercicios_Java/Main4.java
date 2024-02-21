package Ejercicios_Java;

public class Main4 {
    public static void main(String[] args) {
        PracticaExcepciones practica = new PracticaExcepciones(0, 300);

        try {

        } catch(IllegalArgumentException e) {
            System.out.println("se ha producido un error.");
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}
