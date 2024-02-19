package org.example;

import org.example.Model.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Chico cChico = new Chico(1, "Circuito Chico", "2 km por selva y arroyos");
        Medio cMedio = new Medio(2, "Circuito Chico", "5 km por selva, arroyos y barro");;
        Avanzado cAvanzado = new Avanzado(1, "Circuito Chico", "10 km por selva, arroyos, barro y escalada en piedra");;

        Participante juan = new Participante(1234, "Juan", "Perez", 20, 327638297, 327638297, "O-");

        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";



        //Código que arroja excepción
        try {
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch (IndexOutOfBoundsException exception){
            System.out.println(exception.getMessage());
        } finally {
            System.out.println(mensajeFinal);
        }



    }
}