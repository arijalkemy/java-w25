package bootcamp;

import bootcamp.domain.NoPerecedero;
import bootcamp.domain.Perecedero;
import bootcamp.domain.Producto;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main( String[] args ) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Fideos", 1200.0, 2));
        productos.add(new NoPerecedero("Manteca", 1500.0, "Lácteo"));
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcular(5);
        }
        System.out.println("Total: $" + redondearPrecio(total));
    }

    public static String redondearPrecio(double precio) {
        DecimalFormat df_obj = new DecimalFormat("#.##");
        df_obj.setRoundingMode(RoundingMode.FLOOR);
        return df_obj.format(precio);
    }

}
