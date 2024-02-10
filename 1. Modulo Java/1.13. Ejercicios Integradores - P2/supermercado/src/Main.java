import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Cliente(12345678, "Juan", "Perez");
        new Cliente(87654321, "Ana", "Gomez");
        new Cliente(13579246, "Pedro", "Martinez");

        for (Cliente cliente : Cliente.getClientes()) {
            System.out.println(cliente);
        }

        Cliente.removeCliente(12345678);

        for (Cliente cliente : Cliente.getClientes()) {
            System.out.println(cliente);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el DNI del cliente a buscar: ");
        int dni = scanner.nextInt();
        Cliente.getCliente(dni);

        List<Producto> productos = new ArrayList<>();

        Factura factura = new Factura(Cliente.getCliente(876543211), new ArrayList<Producto>());

        System.out.println(factura);

        productos.add(new Producto(1, "Leche", 1, 100));
        productos.add(new Producto(2, "Pan", 1, 50));
        productos.add(new Producto(3, "Yogurt", 1, 200));
        productos.add(new Producto(4, "Queso", 1, 300));
        productos.add(new Producto(5, "Mantequilla", 1, 400));
        productos.add(new Producto(6, "Galletas", 1, 500));
        productos.add(new Producto(7, "Cereal", 1, 600));

        factura.setItems(productos);

        System.out.println(factura);
    }
}