import OpcionesBancarias.ConsultaDeSaldo;
import OpcionesBancarias.Deposito;
import OpcionesBancarias.ITransaccion;
import OpcionesBancarias.PagoDeServicios;
import OpcionesBancarias.RetiroDeEfectivo;
import OpcionesBancarias.Transferencia;
import TipoDeUsuario.Basic;
import TipoDeUsuario.Cobrador;
import TipoDeUsuario.Ejecutivo;
import TipoDeUsuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Usuario basic = new Basic("JuanMa",999L,1500000D);
        Usuario ejecutivo = new Ejecutivo("Carlos",873L,999999999D);
        Usuario cobrador = new Cobrador("Martin",87222L,828282882D);

        List<ITransaccion> transaccions = new ArrayList<>();
        transaccions.add(new ConsultaDeSaldo());
        transaccions.add(new Deposito());
        transaccions.add((new Transferencia()));
        transaccions.add(new PagoDeServicios());
        transaccions.add(new RetiroDeEfectivo());

        basic.realizarTransaccion(transaccions.get(0));
        basic.realizarTransaccion(transaccions.get(4));
        basic.realizarTransaccion(transaccions.get(2));
        basic.realizarTransaccion(transaccions.get(3));

        ejecutivo.realizarTransaccion(transaccions.get(1));
        ejecutivo.realizarTransaccion(transaccions.get(2));
        ejecutivo.realizarTransaccion(transaccions.get(0));

        cobrador.realizarTransaccion(transaccions.get(4));
        cobrador.realizarTransaccion(transaccions.get(0));
        cobrador.realizarTransaccion(transaccions.get(2));
        cobrador.realizarTransaccion(transaccions.get(3));
    }
}
