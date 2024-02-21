import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> listaDePrendas = new ArrayList<>();

        listaDePrendas.add(new Prenda("Gucci", "GC"));
        listaDePrendas.add(new Prenda("Levis", "LV"));


        List<Prenda> listaDePrendas2 = new ArrayList<>();

        listaDePrendas2.add(new Prenda("Otra", "GC"));
        listaDePrendas2.add(new Prenda("Otra2", "LV"));




        System.out.println("Se guardo la prenda en #"+ guardaRopa.guardarPrendas(listaDePrendas));
        System.out.println("Se guardo la prenda en #"+ guardaRopa.guardarPrendas(listaDePrendas2));
        System.out.println("DEVOLVER GUAEDAROPAS 1");
        guardaRopa.devolverPrendas(1).forEach(System.out::println);
        System.out.println("TODAS LAS PRENDAS");
        guardaRopa.mostrarPrendas();

    }
}
