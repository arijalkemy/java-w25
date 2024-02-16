package org.bootcamp.Ejercicio1;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;
    private double resultado;

    public double calcularCociente()
    {
        try {
            if(a == 0)
                throw new IllegalArgumentException("No se puede dividir por cero");
            resultado = b/a;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }/*catch(ArithmeticException e){
            System.out.println("Se ha producido un error " + e.getMessage());
        }*/finally {
            System.out.println("Programa finalizado");
        }


        return resultado;
    }

    public PracticaExcepciones() {
    }
}
