package org.example;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public PracticaExcepciones() {
    }

    public void calcularCociente(){
        try {
            int resultado = b / a;
            System.out.println("El cociente es "+resultado);
        } catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }


}
