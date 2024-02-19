package com.java.exceptions;

import com.java.exceptions.PracticaExcepciones;

public class Main 
{
    public static void main( String[] args )
    {
        PracticaExcepciones practicaExcepciones = new PracticaExcepciones(0, 300);
        double division = practicaExcepciones.dividir();
        System.out.println(division);
        System.out.println("Programa finalizado.");
    }
}
