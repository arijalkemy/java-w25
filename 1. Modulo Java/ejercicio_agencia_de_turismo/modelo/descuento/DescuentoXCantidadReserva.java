package ejerciciosIntegradores.agenciaDeTurismo.modelo.descuento;

import ejerciciosIntegradores.agenciaDeTurismo.modelo.Localizador;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.Paquete;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva.Hotel;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.reserva.Reserva;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class DescuentoXCantidadReserva <T extends Comparator> implements Descuento {

    private T reserva;
    private int cantidad_reservas;
    private double DESCUENTO;

    public DescuentoXCantidadReserva(int cantidad_reservas, double DESCUENTO) {
        this.cantidad_reservas = cantidad_reservas;
        this.DESCUENTO = DESCUENTO;
    }
    @Override
    public double calcularDescuento(Localizador localizador) {
        double descuentoAplicado = 0.0;
        String mensajeDescuento = "Se aplicó un descuento del " + DESCUENTO*100 + "% a";
        for(Paquete p : localizador.getPaquetes()){
            List<Reserva> reservasAplicanDescuento = p.getReservas().stream().filter(this::esValido).toList();
            if (!(reservasAplicanDescuento.size() > this.cantidad_reservas)) continue;
            mensajeDescuento += "reservas de tipo: "  + reserva.getClass().getSimpleName() + " ";
            descuentoAplicado += reservasAplicanDescuento.stream().mapToDouble(r -> r.calcularTotal() * this.DESCUENTO).sum();
        }
        mensajeDescuento += "por tener más de " + this.cantidad_reservas + " reservas para esos tipos";
        if (descuentoAplicado != 0.0) System.out.println(mensajeDescuento);
        return descuentoAplicado;
    }

    public boolean esValido(Reserva reserva) {
        return this.reserva.getClass().equals(T.com));
    }
}
