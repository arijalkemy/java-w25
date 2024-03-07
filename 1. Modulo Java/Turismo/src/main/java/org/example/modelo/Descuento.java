package org.example.modelo;


public class Descuento {

    public static double calcularDescuento(Localizador localizador){

        double descuento = 0;

        if(localizador.getCliente().getLocalizadores().size() >= 2)
            descuento += localizador.getTotal() * 0.05;

        if(esPaquete(localizador))
            descuento += localizador.getTotal() * 0.1;


        descuento += descuentoHoteles(localizador);
        descuento += descuentoBoletos(localizador);

        return descuento;
    }

    private static boolean esPaquete(Localizador localizador){

        return localizador.getReservas().stream().anyMatch(reserva -> reserva instanceof ReservaHotel) &&
                localizador.getReservas().stream().anyMatch(reserva -> reserva instanceof ReservaBoleto) &&
                localizador.getReservas().stream().anyMatch(reserva -> reserva instanceof ReservaComida) &&
                localizador.getReservas().stream().anyMatch(reserva -> reserva instanceof ReservaTransporte);
    }

    private static double descuentoHoteles(Localizador localizador){

        return localizador.getReservas()
                            .stream()
                            .filter(reserva -> reserva.getCantidad()>= 2 && reserva instanceof ReservaHotel)
                            .mapToDouble(reserva -> (reserva.getCantidad() * reserva.getPrecio()) )
                            .sum() * 0.05;

    }
    private static double descuentoBoletos(Localizador localizador){
        return localizador.getReservas()
                .stream()
                .filter(reserva -> reserva.getCantidad()>= 2 && reserva instanceof ReservaBoleto)
                .mapToDouble(reserva -> (reserva.getCantidad() * reserva.getPrecio()) )
                .sum() * 0.05;
    }

}
