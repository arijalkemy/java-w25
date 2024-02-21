import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Lista de Prendas 1
        Prenda remera = new Prenda();
        Prenda medias = new Prenda();
        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(remera);
        listaPrendas.add(medias);
        GuardaRopa guardador = new GuardaRopa();
        Integer idListaPrendas = guardador.guardarPrendas(listaPrendas);

        // Lista de Prendas 2
        Prenda pantalon = new Prenda();
        Prenda calzon = new Prenda();
        List<Prenda> listaPrendas2 = new ArrayList<>();
        listaPrendas2.add(pantalon);
        listaPrendas2.add(calzon);
        Integer idListaPrendas2 = guardador.guardarPrendas(listaPrendas2);

        // Muestra de prendas
        guardador.mostrarPrendas();

        // Mostrar lista de prendas por ID
        System.out.println("-----------------");
        System.out.println("ID de prendas devueltas: " + idListaPrendas);
        for(Prenda p : guardador.devolverPrendas(idListaPrendas)) {
            System.out.println(p);
        }
    }
}
