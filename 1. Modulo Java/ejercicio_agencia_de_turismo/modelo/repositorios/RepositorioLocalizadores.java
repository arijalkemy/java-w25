package ejerciciosIntegradores.agenciaDeTurismo.modelo.repositorios;

import ejerciciosIntegradores.agenciaDeTurismo.modelo.Cliente;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.Localizador;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.Paquete;
import ejerciciosIntegradores.agenciaDeTurismo.modelo.descuento.Descuento;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizadores {
    private static RepositorioLocalizadores instance;
    private List<Localizador> localizadores;
    private List<Descuento> descuentosAplicables;

    private RepositorioLocalizadores () {
        this.localizadores = new ArrayList<>();
        this.descuentosAplicables = new ArrayList<>();
    }

    public List<Descuento> getDescuentosAplicables() {
        return descuentosAplicables;
    }

    public void setDescuentosAplicables(List<Descuento> descuentosAplicables) {
        this.descuentosAplicables = descuentosAplicables;
    }

    public void calcularTotalConDescuentos (Localizador localizador) {
        System.out.println("----- Cliente: " + localizador.getCliente().getNombre() + " " + localizador.getCliente().getApellido() + " -----");
        System.out.println("---------- FacturaTipo: A ----------\n");
        localizador.obtenerReservas(); // imprime reservas
        double total = localizador.calcularTotal();
        System.out.println("----- TOTAL COMPRRA SIN DESCUENTOS: $" + total);
        System.out.println("----- Descuentos aplicados -----");
        double descuento = this.descuentosAplicables.stream().mapToDouble(d -> d.calcularDescuento(localizador)).sum();
        System.out.println("----- TOTAL COMPRA CON DESCUENTOS: $" + (total - descuento));
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public static RepositorioLocalizadores getInstance() {
        if(instance == null) instance = new RepositorioLocalizadores();
        return instance;
    }

    public Localizador generarLocalizador(List<Paquete> paquetes, Cliente cliente){
        Localizador l = new Localizador(cliente);
        l.setPaquetes(paquetes);
        this.localizadores.add(l);
        return l;
    }

    public List<Localizador> getLocalizadorByCliente (Cliente cliente) {
        List<Localizador> localizadores = this.getLocalizadores().stream().filter(l -> l.getCliente().equals(cliente)).toList();
        if(localizadores.isEmpty()) throw new RuntimeException("No se encontrarón registros de localizadores para el cliente: " + cliente.getNombre());
        return localizadores;
    }
}
