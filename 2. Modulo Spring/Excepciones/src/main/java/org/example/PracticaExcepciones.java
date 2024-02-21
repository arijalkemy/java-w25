package org.example;

public class PracticaExcepciones {

    private int a=0;
    private int b=300;


    public void operacion() {

        try {

            int operacion = b / a;

        } catch (ArithmeticException exception) {

            System.out.println("no se puede dividir por 0" + exception.getMessage());

        } finally {

            System.out.println("despues de la division");

        }

    }

    public void operacion2(){


        if (a==0){
            throw new IllegalArgumentException("no se ha podido dividir por 0");
        }
    }
}
