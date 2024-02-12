package org.example;

import org.example.Productos.Boleto;
import org.example.Productos.Comida;
import org.example.Productos.Hotel;
import org.example.Productos.Transporte;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        //Localizador con paquete completo
        LinkedList<Producto> productos = new LinkedList<>();
        productos.add(new Boleto(1, "boleto", 100.0));
        productos.add(new Comida(2, "comida", 100.0));
        productos.add(new Hotel(3, "hotel", 100.0));
        productos.add(new Transporte(4, "transporte", 100.0));
        Reserva reserva = new Reserva(1, productos);


        Repositorio repo = new Repositorio();
        Cliente c1 = new Cliente("Juan", 1234);
        Localizador localizador = new Localizador(1, c1, repo);
        localizador.addReserva(reserva);
        System.out.println(localizador.calcularTotal());

        //-----------------------------------------//
        LinkedList<Producto> paquete = new LinkedList<>();
        paquete.add(new Hotel(4,"nuevo hotel",300.0));
        paquete.add(new Hotel(5,"nuevo hotel",300.0));
        paquete.add(new Boleto(6,"boleto",200.0));
        paquete.add(new Boleto(7,"boleto",200.0));

        Reserva otraReserva= new Reserva(2, paquete);
        Localizador localizadorNuevo = new Localizador(2, c1, repo);
        localizadorNuevo.addReserva(otraReserva);


        repo.addLocalizador(localizador.getClient(), localizador);
        repo.addLocalizador(localizador.getClient(), localizador);

        for(Localizador loc: repo.getLocalizadoresByCliente(c1)){

            System.out.println(loc.getTotal());
        }

        otraReserva.esPaqueteCompleto();


    }
}