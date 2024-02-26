package org.example;

public class PracticaExcepciones {

    int a = 0;
    int b = 300;

    public void calculate() throws IllegalArgumentException{
        try {
            int c = b / a;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones pe = new PracticaExcepciones();
        pe.calculate();
    }
}