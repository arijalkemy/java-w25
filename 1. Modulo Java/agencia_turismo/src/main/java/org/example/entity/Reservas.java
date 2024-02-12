package org.example.entity;


public class Reservas {
    private long id;

    private double precio;
    private DetalleReserva detalleReserva;
    public Reservas(long id, DetalleReserva detalleReserva) {
        this.id = id;
        this.detalleReserva = detalleReserva;
        this.precio = getPrecioInicial(detalleReserva);

    }
    public double getPrecioInicial(DetalleReserva detalleReserva){
        switch (detalleReserva){
            case HOTEL -> {
                return 100.0;
            }
            case COMIDA -> {
                return 20.0;
            }
            case TRANSPORTE -> {
                return 55.0;
            }
            case BOLETO_VIAJE -> {
                return  120.0;
            }
            case PAQUETE_COMPLETO -> {
                return 295;
            }
            default -> {
                return 0.0;
            }
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public DetalleReserva getDetalleReserva() {
        return detalleReserva;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDetalleReserva(DetalleReserva detalleReserva) {
        this.detalleReserva = detalleReserva;
    }
}
