package com.main;

import com.main.Clientes.Basic;
import com.main.Clientes.Cobrador;
import com.main.Clientes.Ejecutivo;
import com.main.Transacciones.*;

public class Main {

    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Deposito deposito = new Deposito();
        Transferencia transferencia = new Transferencia();

        ejecutivo.realizarDeposito(deposito);
        ejecutivo.realizarTransferencia(transferencia);

        Basic basic = new Basic();
        Consulta consultaSaldo = new Consulta();
        PagoServicios pagoServicio = new PagoServicios();
        Retiro retiroEfectivo = new Retiro();

        basic.realizarConsultaSaldo(consultaSaldo);
        basic.realizarPagoServicios(pagoServicio);
        basic.relizarRetiroEfectivo(retiroEfectivo);

        Cobrador cobrador = new Cobrador();
        Consulta consultaSaldo2 = new Consulta();
        Retiro retiroEfectivo2 = new Retiro();

        cobrador.realizarConsultaSaldo(consultaSaldo2);
        cobrador.relizarRetiroEfectivo(retiroEfectivo2);

    }
}
