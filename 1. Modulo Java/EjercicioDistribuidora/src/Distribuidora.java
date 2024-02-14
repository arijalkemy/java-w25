import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Leche",2000,3));
        productos.add(new Perecedero("Leche",2000,1));
        productos.add(new Perecedero("Queso",4000,2));
        productos.add(new Producto("Arroz",15000));
        productos.add(new NoPerecedero("Agua",1900,"Bebida"));

        double total = 0;
        total += productos.get(2).calcular(5);
        System.out.println("El total es: "+total);

        double precioTotal = 0;
        for(Producto producto : productos ){
            precioTotal += producto.calcular(5);
        }
        System.out.println("El total de todos es: "+precioTotal);
    }
}
