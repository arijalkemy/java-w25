import java.util.ArrayList;

public class Distribuidora {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new NoPerecedero("Atún en agua", 120.0, "Enlatado"));
        productos.add(new NoPerecedero("Atún en aceite",100.0,"Enlatado"));
        productos.add(new Perecedero("Pera", 100.0, 1));
        productos.add(new Perecedero("Manzana", 100.0, 3));

        productos.forEach(producto -> {
            System.out.println(producto);
            System.out.println("Total: $" + producto.calcularPrecio(5));
        });


    }
}
