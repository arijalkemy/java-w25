package org.example;

import java.util.List;

public class DescuentoPaqueteCompleto implements Descuento {

    private static final double PORCENTAJE_DESCUENTO = 0.10;

    private Cliente cliente;
    private RepositorioLocalizadores repositorioLocalizadores;

    @Override
    public double aplicarDescuento(double total) {

        List<Localizador> localizadoresCliente = RepositorioLocalizadores.getInstance().getLocalizadorByCliente(cliente);

        boolean paqueteCompleto = localizadoresCliente.stream()
                .anyMatch(Localizador::esPaqueteCompleto);

        return total * (paqueteCompleto ? 1 - PORCENTAJE_DESCUENTO : 1);




    }
}
