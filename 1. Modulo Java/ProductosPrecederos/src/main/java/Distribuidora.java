import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> venta = new ArrayList<>();
        venta.add(new Producto("Escoba", 3180));
        venta.add(new Producto("Detergente", 1650));
        venta.add(new Producto("Plato", 2800));
        venta.add(new Producto("Botella", 1500));
        venta.add(new Producto("Cuchiclo", 1300));
        //Perecederos
        venta.add(new Precedero("Leche", 920, 50));
        venta.add(new Precedero("Manteca", 1300, 3));
        venta.add(new Precedero("Yogurt", 800, 2));
        venta.add(new Precedero("Queso", 3599, 50));
        venta.add(new Precedero("Queso", 3599, 50));
        //No precedero
        venta.add(new NoPrecedero("Lentejas", 350,"conservas"));
        venta.add(new NoPrecedero("Choclo cremoso", 500,"conservas"));
        venta.add(new NoPrecedero("Garbanzos", 700,"conservas"));
        venta.add(new NoPrecedero("Fideos", 1000,"pastas"));
        venta.add(new NoPrecedero("Arroz", 800,"conservas"));

        double totalPrecederos = 0;
        double totalNoPrecederos = 0;
        double totalProductos = 0;
        for(Producto producto : venta) {
            if(producto instanceof Precedero){
                totalPrecederos += producto.calcular(1);
            }
            if(producto instanceof NoPrecedero){
                totalNoPrecederos += producto.calcular(1);
            }
            else {
                totalProductos += producto.calcular(1);
            }
        }
        System.out.println("totalPrecederos"+totalPrecederos);
        System.out.println("totalNoPrecederos"+totalNoPrecederos);
        System.out.println("totalProductos"+totalProductos);
    }
}
