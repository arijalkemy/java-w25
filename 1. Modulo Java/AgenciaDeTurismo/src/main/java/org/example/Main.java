package org.example;

import org.example.clases.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Daniela", "Villadiego", "123456789");

        List<Paquete> listaPaquete = List.of(
                new Comida(1, 1500.50),
                new Transporte(10, 2500.0),
                new Boletos(10, 2500.0)
        );
        Localizador localizador1 = new Localizador(cliente,listaPaquete) ;

        //calcularDescuento();

        System.out.println(localizador1.toString());
    }

    public static double calcularDescuento(){
        return 0.0;
    }
}