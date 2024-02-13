package ejerciciosIntegradores.agenciaDeTurismo.modelo.descuento;

import ejerciciosIntegradores.agenciaDeTurismo.modelo.Localizador;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.repositorios.RepositorioLocalizadores;

public class DescuentoXCantidadLocalizadores implements Descuento{

    private int localizadores_anteriores;
    private double DESCUENTO; // esta entre 0 y 1

    public DescuentoXCantidadLocalizadores(int localizadores_anteriores, double DESCUENTO) {
        this.localizadores_anteriores = localizadores_anteriores;
        this.DESCUENTO = DESCUENTO;
    }

    @Override
    public double calcularDescuento(Localizador localizador) {
        double descuentoAAplicar = (this.esValido(localizador)) ? this.DESCUENTO * localizador.calcularTotal()  : 0;
        if (descuentoAAplicar != 0.0) System.out.println("Se aplicó un descuento del " + DESCUENTO*100 + "% " + "($" + descuentoAAplicar + ") por tener más de 2 localizaciones");
        return descuentoAAplicar;
    }

    public boolean esValido(Localizador localizador) {
        return !RepositorioLocalizadores.getInstance().getLocalizadorByCliente(localizador.getCliente()).isEmpty();
    }
}
