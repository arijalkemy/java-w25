package org.example;

public class PracticaExcepciones {
    private static final int a = 0;
    private static final int b = 300;

    public static void cociente() {
        try {
            int c = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero", e);
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
