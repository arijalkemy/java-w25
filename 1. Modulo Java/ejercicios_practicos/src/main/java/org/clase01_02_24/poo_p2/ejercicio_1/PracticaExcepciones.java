package org.clase01_02_24.poo_p2.ejercicio_1;

public class PracticaExcepciones {
    int a;
    int b;

    public int calcular(){
        try {
            return b/a;
        } catch (ArithmeticException e){
            throw new IllegalArgumentException("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
