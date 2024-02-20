package org.example;

public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public static void calcularCociente(){
        try {
            double res = b/a;
        }catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
