package ejerciciosIntegradores.agenciaDeTurismo.modelo.descuento;

import ejerciciosIntegradores.agenciaDeTurismo.modelo.Localizador;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.Paquete;

public class DescuentoPaqueteCompleto implements Descuento{
    private double DESCUENTO;

    public DescuentoPaqueteCompleto(double DESCUENTO) {
        this.DESCUENTO = DESCUENTO;
    }

    @Override
    public double calcularDescuento(Localizador localizador) {
        double descuentoAAplicar = (this.esValido(localizador)) ? localizador.calcularTotal() * this.DESCUENTO : 0;
        if(descuentoAAplicar != 0.0) System.out.println("Se aplico un descuento por comprar un paquete completo de " + DESCUENTO*100 + "% ($" + descuentoAAplicar + ")");
        return  descuentoAAplicar;
    }

    public boolean esValido(Localizador localizador) {
        return !localizador.getPaquetes().stream().filter(Paquete::esPaqueteCompleto).toList().isEmpty();
    }
}
