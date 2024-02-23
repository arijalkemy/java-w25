package org.example;

public class PracticaExcepciones {
    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        try{
            //Segundo caso
            if (a == 0){
                throw new IllegalArgumentException(" No se puede dividir por cero");
            }
            //Primer caso
            double c = b / a;
        } catch (IllegalArgumentException e) {
            //Primer caso: Exception
            System.out.println("Se ha producido un error" + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}