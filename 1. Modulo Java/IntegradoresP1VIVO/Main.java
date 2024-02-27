package IntegradoresP1VIVO;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Crear reservas para el primer cliente
        List<Reserva> reservasCliente1 = Arrays.asList(
                new Reserva("hotel", 200),
                new Reserva("comida", 50),
                new Reserva("boleto", 100),
                new Reserva("transporte", 30)
        );

        // Crear localizador para el primer cliente
        Localizador localizadorCliente1 = new Localizador("Cliente1", reservasCliente1);

        // Crear reservas adicionales para el primer cliente
        List<Reserva> reservasCliente1Adicionales = Arrays.asList(
                new Reserva("hotel", 150),
                new Reserva("boleto", 120)
        );

        // Crear localizador adicional para el primer cliente
        Localizador localizadorCliente1Adicional = new Localizador("Cliente1", reservasCliente1Adicionales);

        // Crear reservas para el segundo cliente
        List<Reserva> reservasCliente2 = Collections.singletonList(
                new Reserva("hotel", 300)
        );

        // Crear localizador para el segundo cliente
        Localizador localizadorCliente2 = new Localizador("Cliente2", reservasCliente2);

        // Crear repositorio de clientes
        RepositorioCliente repositorioCliente = new RepositorioCliente();

        // Agregar localizadores al repositorio de clientes
        repositorioCliente.agregarLocalizador(localizadorCliente1.getCliente(), localizadorCliente1);
        repositorioCliente.agregarLocalizador(localizadorCliente1Adicional.getCliente(), localizadorCliente1Adicional);
        repositorioCliente.agregarLocalizador(localizadorCliente2.getCliente(), localizadorCliente2);

        // Imprimir localizadores y verificar descuentos aplicados
        System.out.println("Localizadores del Cliente1:");
        repositorioCliente.obtenerLocalizadores("Cliente1").forEach(Localizador::imprimirLocalizador);

        System.out.println("Localizadores del Cliente2:");
        repositorioCliente.obtenerLocalizadores("Cliente2").forEach(Localizador::imprimirLocalizador);

        // Consultas opcionales
        System.out.println("Cantidad de localizadores vendidos: " + repositorioCliente.cantidadLocalizadoresVendidos());
        System.out.println("Cantidad total de reservas: " + repositorioCliente.cantidadTotalReservas());
        System.out.println("Reservas clasificadas por tipo: " + repositorioCliente.reservasClasificadasPorTipo());
        System.out.println("Total de ventas: " + repositorioCliente.totalVentas());
        System.out.println("Promedio de ventas: " + repositorioCliente.promedioVentas());
    }
}
// Clase para representar una reserva
class Reserva {
    private String tipo;
    private double precio;

    public Reserva(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
}

// Clase para representar un localizador
class Localizador {
    private String cliente;
    private List<Reserva> reservas;

    public Localizador(String cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    // Método para calcular el total de la factura
    public double calcularTotal() {
        return reservas.stream()
                .mapToDouble(Reserva::getPrecio)
                .sum();
    }

    // Método para aplicar descuentos
    public double aplicarDescuentos() {
        long numReservasHotel = reservas.stream()
                .filter(r -> r.getTipo().equals("hotel"))
                .count();

        long numReservasBoleto = reservas.stream()
                .filter(r -> r.getTipo().equals("boleto"))
                .count();

        double total = calcularTotal();

        if (numReservasHotel >= 2 || numReservasBoleto >= 2) {
            return total * 0.95; // Descuento del 5%
        } else if (reservas.size() == 4) {
            return total * 0.9; // Descuento del 10% para paquete completo
        } else if (reservas.size() >= 2) {
            return total * 0.95; // Descuento del 5% por haber adquirido al menos 2 localizadores anteriormente
        }

        return total;
    }

    // Método para imprimir el localizador con los detalles de la compra
    public void imprimirLocalizador() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Reservas:");

        for (Reserva reserva : reservas) {
            System.out.println("- Tipo: " + reserva.getTipo() + ", Precio: " + reserva.getPrecio());
        }

        System.out.println("Total: " + calcularTotal());
        System.out.println("Total con descuento: " + aplicarDescuentos());
        System.out.println();
    }

}

// Clase repositorio de clientes
class RepositorioCliente {
    private Map<String, List<Localizador>> clientes;

    public RepositorioCliente() {
        this.clientes = new HashMap<>();
    }

    public void agregarLocalizador(String cliente, Localizador localizador) {
        clientes.computeIfAbsent(cliente, k -> new ArrayList<>()).add(localizador);
    }

    public List<Localizador> obtenerLocalizadores(String cliente) {
        return clientes.getOrDefault(cliente, new ArrayList<>());
    }

    // Métodos opcionales para consultas sobre los localizadores vendidos
    public int cantidadLocalizadoresVendidos() {
        return clientes.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    public int cantidadTotalReservas() {
        return clientes.values().stream()
                .flatMap(List::stream)
                .mapToInt(localizador -> localizador.getReservas().size())
                .sum();
    }

    public Map<String, List<Reserva>> reservasClasificadasPorTipo() {
        return clientes.values().stream()
                .flatMap(List::stream)
                .flatMap(localizador -> localizador.getReservas().stream())
                .collect(Collectors.groupingBy(Reserva::getTipo));
    }

    public double totalVentas() {
        return clientes.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Localizador::calcularTotal)
                .sum();
    }

    public double promedioVentas() {
        return totalVentas() / cantidadLocalizadoresVendidos();
    }
}

