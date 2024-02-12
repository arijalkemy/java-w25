package org.example.exercise1;

public class ExceptionsPractice {
    private final int A = 0;
    private final int B = 300;

    public int divideBandA() {
        int result = 0;
        try {
            result = this.B / this.A;
        } catch (Exception exception) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("El programa ha finalizado");
        }
        return result;
    }
}
