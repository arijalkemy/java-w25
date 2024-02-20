public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[5];
        productos[0] = new Perecedero("Leche", 100, 1);
        productos[1] = new Perecedero("Queso", 200, 2);
        productos[2] = new NoPerecedero("Arroz", 125, "Cereal");
        productos[3] = new NoPerecedero("Cafe", 300, "Grano");
        productos[4] = new Perecedero("Pescado", 500, 3);

        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " " + producto.calcular(5));
        }
    }
}
