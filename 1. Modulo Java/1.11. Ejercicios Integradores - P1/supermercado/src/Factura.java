import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Factura {
    private static List<Factura> facturas = new ArrayList<>();
    private Cliente cliente;
    private List<Producto> items = new ArrayList<Producto>();
    private double total;

    public Factura(Cliente cliente, List<Producto> items) {
        if (cliente == null) {
            System.out.println("El cliente no se encuentra registrado. Registrelo primero...");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el DNI del cliente: ");
            int dni = scanner.nextInt();
            System.out.println("Ingrese el nombre del cliente: ");
            String nombre = scanner.next();
            System.out.println("Ingrese el apellido del cliente: ");
            String apellido = scanner.next();
            Cliente nuevoCliente = new Cliente(dni, nombre, apellido);
            this.cliente = nuevoCliente;
        } else {
            this.cliente = cliente;
        }
        this.items = items;
        this.total = items.stream().mapToDouble(producto -> producto.getCantidad() * producto.getPrecio()).sum();
        facturas.add(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getItems() {
        return items;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
        this.total = items.stream().mapToDouble(producto -> producto.getCantidad() * producto.getPrecio()).sum();
    }

    public void addItem(Producto item) {
        this.items.add(item);
    }

    public Producto removeItem(int codigo) {
        for (Producto item : items) {
            if (item.getCodigo() == codigo) {
                this.items.remove(item);
                return item;
            }
        }
        return null;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
