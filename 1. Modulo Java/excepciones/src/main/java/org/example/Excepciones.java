package org.example;

public class Excepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try{
            System.out.println(b/a);
        } catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally{
            System.out.println("El programa ha finalizado");
        }
    }
}
