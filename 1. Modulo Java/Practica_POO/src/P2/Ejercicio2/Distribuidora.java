package P2.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> venta = new ArrayList<>();
        //Productos
        venta.add(new Producto("Escoba", 3180));
        venta.add(new Producto("Detergente", 1650));
        venta.add(new Producto("Plato", 2800));
        venta.add(new Producto("Botella", 1500));
        venta.add(new Producto("Cuchiclo", 1300));
        //Perecederos
        venta.add(new Perecedero("Leche", 920, 50));
        venta.add(new Perecedero("Manteca", 1300, 3));
        venta.add(new Perecedero("Yogurt", 800, 2));
        venta.add(new Perecedero("Queso", 3599, 50));
        venta.add(new Perecedero("Queso Crema", 1200, 1));
        //NoPerecederos
        venta.add(new NoPerecedero("Fideos", 980, "pasta"));
        venta.add(new NoPerecedero("Arroz", 3500, "cereales"));
        venta.add(new NoPerecedero("Atun enlatado", 4000, "conserva"));
        venta.add(new NoPerecedero("Porotos", 2200, "legumbres"));
        venta.add(new NoPerecedero("Garbanzos", 5000, "legumbres"));
        double total = 0.0;
        for(Producto p : venta){
            total += p.calcular(1);
        }
        System.out.println("El total es " + total);

    }
}
