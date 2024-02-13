package org.example.ejercicio_1_banco;

import org.example.ejercicio_1_banco.clientes.Basic;
import org.example.ejercicio_1_banco.clientes.Cliente;
import org.example.ejercicio_1_banco.clientes.Cobrador;
import org.example.ejercicio_1_banco.clientes.Ejecutivo;

public class Banco {
    public static void main(String[] args) {

        System.out.println("\nCliente BASIC intentando operar:");
        Cliente basic = new Basic();
        basic.consultarSaldo();
        basic.depositar();
        basic.pagarServicios();
        basic.retirarEfectivo();
        basic.transferir();

        System.out.println("\nCliente COBRADOR intentando operar:");
        Cliente cobrador = new Cobrador();
        cobrador.consultarSaldo();
        cobrador.depositar();
        cobrador.pagarServicios();
        cobrador.retirarEfectivo();
        cobrador.transferir();

        System.out.println("\nCliente EJECUTIVO intentando operar:");
        Cliente ejecutivo = new Ejecutivo();
        ejecutivo.consultarSaldo();
        ejecutivo.depositar();
        ejecutivo.pagarServicios();
        ejecutivo.retirarEfectivo();
        ejecutivo.transferir();
    }
}
