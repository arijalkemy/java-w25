package org.example.modelo;


public class Descuento {

    public static double calcularDescuentoTotal(Localizador localizador) {

        double descuento = 0;

        if (esPaquete(localizador))
            descuento += 0.1;

        return descuento;
    }

    public static double calcularDescuentoReservas(Localizador localizador) {
        double descuento = 0;
        if (descuentoBoletos(localizador) || descuentoHoteles(localizador))
            descuento = 0.05;

        return descuento;
    }

    public static double descuentoFuturaCompra(Venta compra) {
        double descuento = 0;
        if (compra.getLocalizadores().size() >= 2)
            descuento = 0.05;
        return descuento;
    }

    private static boolean esPaquete(Localizador localizador) {

        return localizador.getReservas().stream()
                .anyMatch(reserva -> reserva instanceof ReservaHotel)
                && localizador.getReservas().stream()
                        .anyMatch(reserva -> reserva instanceof ReservaBoleto)
                && localizador.getReservas().stream()
                        .anyMatch(reserva -> reserva instanceof ReservaComida)
                && localizador.getReservas().stream()
                        .anyMatch(reserva -> reserva instanceof ReservaTransporte);
    }

    private static boolean descuentoHoteles(Localizador localizador) {

        return localizador.getReservas().stream()
                .anyMatch(reserva -> reserva.getCantidad() >= 2 && reserva instanceof ReservaHotel);
    }

    private static boolean descuentoBoletos(Localizador localizador) {
        return localizador.getReservas().stream()
                .anyMatch(reserva -> reserva.getCantidad() >= 2 && reserva instanceof ReservaBoleto);
    }

}
