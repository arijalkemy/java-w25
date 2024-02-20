package org.example;

import org.example.model.Cliente;
import org.example.model.Localizador;
import org.example.model.RepositorioLocalizador;
import org.example.model.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado
        Cliente clienteCarlos = new Cliente(1,"Carlos");
        List<Reserva> listaReservaCarlos = new ArrayList<>();
        listaReservaCarlos.add(new Reserva(1,"Hotel",230));
        listaReservaCarlos.add(new Reserva(2,"Comida",1000));
        listaReservaCarlos.add(new Reserva(3,"Vuelo",500));
        listaReservaCarlos.add(new Reserva(4,"Transporte",200));
        Localizador localizador = new Localizador(1, clienteCarlos,listaReservaCarlos);

        RepositorioLocalizador.guardarLocalizador(localizador);

        //Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
        List<Reserva> listaReservaCarlos2 = new ArrayList<>();
        listaReservaCarlos2.add(new Reserva(1,"Hotel",300));
        listaReservaCarlos2.add(new Reserva(1,"Hotel",1000));
        listaReservaCarlos2.add(new Reserva(3,"Vuelo",500));
        listaReservaCarlos2.add(new Reserva(3,"Vuelo",500));
        Localizador localizador2 = new Localizador(2,clienteCarlos,listaReservaCarlos2);

        RepositorioLocalizador.guardarLocalizador(localizador2);

        //Crear un localizador con una sola reserva para el mismo cliente.
        List<Reserva> listaReservaCarlos3 = new ArrayList<>();
        listaReservaCarlos3.add(new Reserva(1,"Hotel",200));
        Localizador localizador3 = new Localizador(3,clienteCarlos,listaReservaCarlos3);

        RepositorioLocalizador.guardarLocalizador(localizador3);

        System.out.println("===============================");
        System.out.println(localizador2);
        //despues de aplicar descuentos
        localizador2.aplicarDescuento();
        System.out.println(localizador2);

        //Parte opcional
        System.out.println();
        System.out.println("=================PARTE OPCIONAL============");
        System.out.println("Cantidad de localizadores vendidos: "+ cantidadLocalizadoresVendidos());
        System.out.println("Cantidad de reservas: " + cantidadReservas());
    }

    public static int cantidadLocalizadoresVendidos(){
        return (int) RepositorioLocalizador.localizadorList.stream().count();
    }

    public static int cantidadReservas() {
        return (int)RepositorioLocalizador.localizadorList.stream()
                .map(x -> (long) x.getListaReserva().size())
                .collect(Collectors.summarizingInt(Long::intValue))
                .getSum();
    }



}