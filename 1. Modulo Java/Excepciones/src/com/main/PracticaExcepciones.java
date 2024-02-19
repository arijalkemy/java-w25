package com.main;

public class PracticaExcepciones {
    private int a=0;
    private int b=300;

    public PracticaExcepciones() {
        this.a = a;
        this.b = b;
    }

    public void operacion(){
        try{
            double operacion=this.b/this.a;
        } catch (ArithmeticException e) {
            System.out.println("--- Se ha producido un error: "+e);
        }finally {
            System.out.println("Programa finalizado");
        }
    }
    public void operacionDos(){
        try{
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            double operacion=this.b/this.a;
        } catch (IllegalArgumentException e) {
            System.out.println("--- Se ha producido un error: "+e);
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
