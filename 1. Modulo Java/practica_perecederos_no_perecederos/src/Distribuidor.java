import java.util.ArrayList;

public class Distribuidor {
    private static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {

        int precioCarrito = 0;

        productos.add(new Perecedero("Leche", 100, 1));
        productos.add(new NoPerecedero("Coca-Cola", 200, "Bebida"));
        productos.add(new Perecedero("Yogurt", 300, 2));
        productos.add(new NoPerecedero("Pan", 400, "Panadería"));
        productos.add(new Perecedero("Queso", 500, 3));
        productos.add(new NoPerecedero("Cerveza", 600, "Bebida"));
        productos.add(new Perecedero("Huevos", 700, 4));
        productos.add(new NoPerecedero("Galletas", 800, "Panadería"));
        productos.add(new Perecedero("Mantequilla", 900, 5));
        productos.add(new NoPerecedero("Jugo", 1000, "Bebida"));

        for(Producto p: productos){
            precioCarrito += p.calcular(5);
        }

        System.out.println("El precio final del carrito es: " + precioCarrito);

    }
}
