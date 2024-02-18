package org.example;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public int calcularCociente() throws IllegalAccessException {
        try {
            return b / a;
        } catch (ArithmeticException e) {
            throw new IllegalAccessException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado.");
        }
    }
}
