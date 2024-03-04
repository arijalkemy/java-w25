import java.util.ArrayList;
import java.util.List;

// Crear una clase ejecutable llamada Distribuidora donde van a crear un array de productos,
// imprimir el precio total al vender 5 productos de cada tipo. Crear los elementos del array
// con los datos que quieras.
public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();

        Perecedero producto1 = new Perecedero("harina", 100, 1);
        NoPerecedero producto2 = new NoPerecedero("harina2", 101, "congelado");

        System.out.println("Total de perecedero: "+producto1.toString()+producto1.calcular(5));
        System.out.println("Total de No perecedero: "+producto2.toString()+"\ntotal: "+producto2.calcular(5));

    }


}
