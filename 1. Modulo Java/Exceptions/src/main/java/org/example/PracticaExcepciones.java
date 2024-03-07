package org.example;

public class PracticaExcepciones {

    int a = 0;
    int b = 300;


    public int calcular(int n1, int n2){
        int res = 0;
        try {
            res = n1 / n2;
        }catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por Cero ", e);
        } finally {
            System.out.println("Programa finalizado");
        }
        return res;

    }
}
