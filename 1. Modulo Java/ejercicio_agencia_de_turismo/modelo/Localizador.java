package ejerciciosIntegradores.agenciaDeTurismo.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Localizador {
    private Cliente cliente;
    private List<Paquete> paquetes;

    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.paquetes = new ArrayList<>();
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public Cliente getCliente () {
        return cliente;
    }

    public double calcularTotal () { return paquetes.stream().mapToDouble(Paquete::calcularTotal).sum(); }
    public void obtenerReservas () { this.getPaquetes().forEach(System.out::println); }
}
