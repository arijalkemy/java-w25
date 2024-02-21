package main.java.com.bootcamp;

public class Practica {
    private int a = 0;
    private int b = 300;
    public int calcularCociente(){
        int resultado = 0;
        try {
            resultado = b/a;
        } catch (ArithmeticException ex){
            System.out.println("Se produjo un error");
        } finally{
            System.out.println("Programa finalizado");
        }
        return resultado;
    }

    public int calcularCocienteConExcepcion(){
        int resultado = 0;
        try {
            resultado = b/a;
        } catch (ArithmeticException ex){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally{
            System.out.println("Programa finalizado");
        }
        return resultado;
    }
}

