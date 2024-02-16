package org.example.modelo;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Venta {
    Cliente cliente;
    List<Localizador> localizadores = new ArrayList<>();
    private EstadoCompra estado = EstadoCompra.PENDIENTE;
    private double subtotal;
    private double total; // Total con descuento

    public Venta(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
        this.calcularSubtotal();
        this.calcularTotal();
    }

    public void calcularSubtotal() {
        this.subtotal = this.getLocalizadores().stream()
                .mapToDouble(localizador -> localizador.getTotal()).sum();
    }

    public void calcularTotal() {
        this.total = subtotal * (1 - (this.cliente.getFuturoDescuento() + this.getLocalizadores()
                .stream().mapToDouble(localizador -> Descuento.calcularDescuentoTotal(localizador))
                .sum()));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

        public EstadoCompra getEstado() {
            return estado;
        }
    
        public double getSubtotal() {
            return subtotal;
        }
    
        public double getTotal() {
            return total;
        }

    public boolean aprobarCompra() {
        if (Math.random() >= 0.5)
            this.estado = EstadoCompra.APROBADO;
        return this.estado == EstadoCompra.APROBADO;
    }

    public boolean cancelarCompra() {
        if (this.estado != EstadoCompra.APROBADO)
            this.estado = EstadoCompra.RECHAZADO;
        return this.estado == EstadoCompra.RECHAZADO;
    }

    @Override
    public String toString() {
        return "Compra [cliente=" + cliente + ", localizadores=" + localizadores + ", estado="
                + estado + ", subtotal=" + subtotal + ", total=" + total + "]";
    }

    

}
