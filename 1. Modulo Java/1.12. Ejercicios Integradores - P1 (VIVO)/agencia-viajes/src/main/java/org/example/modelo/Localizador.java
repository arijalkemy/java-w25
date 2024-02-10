package org.example.modelo;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class Localizador {
    Cliente cliente;
    List<Reserva> reservas;
    double total;

    public Localizador(Cliente cliente, List<Reserva> lista){
        this.cliente = cliente;
        this.reservas = lista;
        actualizarTotal();
    }

    private void actualizarTotal(){
        this.total = this.reservas.stream()
                .mapToDouble(reserva -> reserva.getPrecio() * reserva.getCantidad())
                .sum();
        this.total -= Descuento.calcularDescuento( this);
    }

    public List<Reserva> getReserva(){
        return this.reservas;
    }

}
