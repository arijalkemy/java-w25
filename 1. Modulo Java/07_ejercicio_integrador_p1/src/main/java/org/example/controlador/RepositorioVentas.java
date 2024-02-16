package org.example.controlador;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.example.modelo.EstadoCompra;
import org.example.modelo.Venta;

import java.util.ArrayList;
import java.util.List;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RepositorioVentas {
    List<Venta> ventas = new ArrayList<>();

    public void agregarVenta(Venta venta) {
        this.ventas.add(venta);
    }

    public double totalVentas() {
        return this.ventas.stream()
                .filter(venta -> venta.getEstado() == EstadoCompra.APROBADO)
                .mapToDouble(venta -> venta.getLocalizadores().stream()
                        .mapToDouble(localizador -> localizador.getTotal()).sum()).sum();
    }

    public int totalLocalizadoresVendidos() {
        return (int) this.ventas.stream()
        .filter(venta -> venta.getEstado() == EstadoCompra.APROBADO).mapToDouble(venta -> venta.getLocalizadores().size())
                .sum();
    }

    public double promedioVentas() {
        return this.ventas.stream()
        .filter(venta -> venta.getEstado() == EstadoCompra.APROBADO)
                .mapToDouble(venta -> venta.getLocalizadores().stream()
                        .mapToDouble(loc -> loc.getTotal()).average().orElse(0))
                .average().orElse(0);
    }

    public int totalReservas() {
        return (int) this.ventas.stream()
                .mapToDouble(
                        venta -> venta
                                .getLocalizadores().stream().mapToDouble(loc -> (loc.getReservas()
                                        .stream().mapToDouble(res -> res.getCantidad()).sum()))
                                .sum())
                .sum();
    }

}
