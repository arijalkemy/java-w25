package org.example;

public class PracticaException {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            int cociente = b / a;
            System.out.println("Cociente: " + cociente);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        }
    }
}
