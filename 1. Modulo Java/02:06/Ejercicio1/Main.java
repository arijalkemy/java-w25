package com.example;

import com.example.classes.*;
import com.example.repository.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Parte 1:
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();
        RepositorioCliente repositorioCliente = new RepositorioCliente();

        // a:
        Cliente cliente1 = new Cliente("Nombre1", "Apellido1");
        Localizador localizador1 = new Localizador(true, 2, 2, 100);
        repositorioLocalizador.getlistaLocalizadoresGenerados().add(localizador1);
        repositorioCliente.agregarCliente(cliente1, localizador1);
        System.out.println(repositorioCliente.getListaClientes());

        // b:
        Localizador localizador2 = new Localizador(true, 2, 2, 200);
        repositorioCliente.agregarCliente(cliente1, localizador2);
        System.out.println(repositorioCliente.getListaClientes());

        // c:
        Localizador localizador3 = new Localizador(true, 1, 1, 300);
        repositorioCliente.agregarCliente(cliente1, localizador3);
        System.out.println(repositorioCliente.getListaClientes());

        // d:
        System.out.println("El valor total es de: " + repositorioCliente.calcularTotal());

        // Parte 2:
        Reporte reporte1 = new Reporte(repositorioCliente.getListaClientes());

        // a:
        System.out.println("Cantidad de localizadores vendidos: " + reporte1.cantidadLocalizadoresVendidos());

        // b:
        System.out.println("Cantidad total de reservas: " + reporte1.cantidadReservas());

        // d:
        System.out.println("Total de ventas: " + reporte1.totalVentas());

        // f:
        System.out.println("Promedio de todas ventas: " + reporte1.promedioVentas());
    }
}
