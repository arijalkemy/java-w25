package Ejercicio1;

import Ejercicio1.Clientes.Basic;
import Ejercicio1.Clientes.Cliente;
import Ejercicio1.Clientes.Cobrador;
import Ejercicio1.Clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Cliente basic = new Basic();
        Cliente cobrador = new Cobrador();
        Cliente ejecutivo = new Ejecutivo();
        System.out.println("============================BASIC================================");
        basic.realizarDeposito();
        basic.realizarTransferencia();
        basic.realizarRetiro();
        basic.realizarConsulta();
        basic.realizarPago();
        System.out.println("===========================COBRADOR==============================");
        cobrador.realizarDeposito();
        cobrador.realizarTransferencia();
        cobrador.realizarRetiro();
        cobrador.realizarConsulta();
        cobrador.realizarPago();
        System.out.println("==========================EJECUTIVO==============================");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();
        ejecutivo.realizarRetiro();
        ejecutivo.realizarConsulta();
        ejecutivo.realizarPago();

    }
}