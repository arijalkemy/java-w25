package org.example.ejercicio1;

public class PracticaExcepciones {

    public static int a = 0;
    public static int b = 300;

    public static void dividir(){
        System.out.println(b/a);
    }

    public static void main(String[] args) {
        try {
            dividir();
        }catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
