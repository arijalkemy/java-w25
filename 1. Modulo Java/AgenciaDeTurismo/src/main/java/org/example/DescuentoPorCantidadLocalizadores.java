package org.example;

import java.util.List;

public class DescuentoPorCantidadLocalizadores implements Descuento{

    private static final double PORCENTAJE_DESCUENTO = 0.05;
    private static final int CANTIDAD_MINIMA_LOCALIZADORES = 2;

    private Cliente cliente;

    public DescuentoPorCantidadLocalizadores(Cliente cliente){
        this.cliente = cliente;
    }

    @Override
    public double aplicarDescuento(double total) {
       // RepositorioLocalizadores.getInstance().getLocalizadorByCliente(cliente);
        List<Localizador> localizadoresCliente = RepositorioLocalizadores.getInstance().getLocalizadorByCliente(this.cliente);
        return localizadoresCliente.size() > CANTIDAD_MINIMA_LOCALIZADORES ? total * (1 - PORCENTAJE_DESCUENTO) : total;

    }
}
