package com.java.exceptions;

public class PracticaExcepciones {
    private double a;
    private double b;
    
    public PracticaExcepciones(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    public double dividir() {
        double division = 0.0;
        // try {
        division = b / a;
        if (division == Double.POSITIVE_INFINITY) {
            throw new IllegalArgumentException("No se puede dividir or cero.");
        }
        return division;
    }
}
