package org.example.models;

public class ExcepcionesPractica {
    public int a = 0;
    public int b = 300;

    public double forzarError(){
        double resultado = 0.0;
        try {
            resultado = a/b;
        }catch (ArithmeticException err){
            System.out.println("No se puede dividir entre 0:"+ err);
        }
        return resultado;
    }
}
