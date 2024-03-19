package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        RepositorioLocalizador listaLocalizadores = new RepositorioLocalizador();
        RepositorioCliente listaClientes = new RepositorioCliente();
        int flag = 0;
        do{
            listaClientes.agregarCliente(listaLocalizadores);
            System.out.println("Personalizar y comprar nuevo paquete:\n1. Digite '1' para SÍ.\n2. Digite cualquier otro numero para NO");
            flag = Integer.parseInt(keyboard.nextLine());
        }while(flag == 1);

        System.out.println("--------ESTA ES LA LISTA DE CLIENTES--------");
        for (Cliente cli : listaClientes.getListaClientes()) {
            System.out.println(cli);
            System.out.println();
        }
        System.out.println("--------ESTA ES LA LISTA DE LOCALIZADORES--------");
        System.out.println(listaLocalizadores.getLocalizadorList());
        for (Localizador loc : listaLocalizadores.getLocalizadorList()) {
            System.out.println(loc);
            System.out.println();
        }

        Consultas busquedasLocalizadores = new Consultas(listaLocalizadores.getLocalizadorList());
        busquedasLocalizadores.cantidadLocalizadoresVendidos();
        busquedasLocalizadores.cantidadTotalReservas();
        busquedasLocalizadores.diccionarioReservas();
        busquedasLocalizadores.totalVendido();
        busquedasLocalizadores.promedioVentasLocalizadores();

    }
}